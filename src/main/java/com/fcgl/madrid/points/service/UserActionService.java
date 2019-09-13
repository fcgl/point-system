package com.fcgl.madrid.points.service;

import com.fcgl.madrid.points.model.*;
import com.fcgl.madrid.points.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserActionService {
    private UserActionRepository userActionRepository;
    private ActionRepository actionRepository;
    private TrophyRepository trophyRepository;
    private UserTrophyRepository userTrophyRepository;
    private UserPointsRepository userPointsRepository;

    @Autowired
    public UserActionService(UserActionRepository userActionRepository,
                             ActionRepository actionRepository,
                             TrophyRepository trophyRepository,
                             UserTrophyRepository userTrophyRepository,
                             UserPointsRepository userPointsRepository) {
        this.userActionRepository = userActionRepository;
        this.actionRepository = actionRepository;
        this.trophyRepository = trophyRepository;
        this.userTrophyRepository = userTrophyRepository;
        this.userPointsRepository = userPointsRepository;
    }

    public List<UserAction> findAll() {
        return userActionRepository.findAll();
    }

    public ResponseEntity<Trophy> addUserAction(Long userID, Long actionID) {

        // Check that the action exists
        Action action = actionRepository.findById(actionID).orElse(null);
        if (action == null) {
            return ResponseEntity.badRequest().body(null);
        }

        UserAction userAction = getUserAction(userID, action);

        UserPoint userPoint = getUserPoints(userID, action);

        Trophy trophy = getTrophy(userID, action, userAction, userPoint);

        // Update User Points
        userPointsRepository.save(userPoint);

        return ResponseEntity.ok().body(trophy);
    }

    private Trophy getTrophy(Long userID, Action action, UserAction userAction, UserPoint userPoint) {
        Trophy trophy = trophyRepository.findByAction(action).orElse(null);

        // if a trophy exists for this action
        if (trophy != null) {
            // if the count of actions qualifies the user for a trophy
            if (userAction.getCount() % trophy.getActionCount() == 0) {
                // Check if this user has earned this trophy before
                UserTrophy userTrophy = userTrophyRepository.getByUserId(userID).orElse(null);
                if (userTrophy == null) {
                    // Create a new user trophy with count equal to one
                    userTrophy = new UserTrophy(userID, trophy, 1);
                } else {
                    // Otherwise, just increment the counter of for this trophy for that user
                    userTrophy.setCount(userTrophy.getCount() + 1);
                }
                userTrophyRepository.save(userTrophy);

                // Update user points with the number of points for this trophy
                userPoint.setTotalPoints(userPoint.getTotalPoints() + trophy.getNumberOfPoints());
            } else {
                // If the number of action count does not yet qualify for trophy
                // Nullify the trophy, so it's not returned back to the caller
                trophy = null;
            }
        }
        return trophy;
    }

    private UserPoint getUserPoints(Long userID, Action action) {
        UserPoint userPoint = userPointsRepository.getByUserId(userID).orElse(null);
        if (userPoint == null) {
            // Create a new userPoint with tournament set to zero
            userPoint = new UserPoint(userID, action.getPoints(), 0);
        } else {
            // Update points with the number of points for this action
            userPoint.setTotalPoints(userPoint.getTotalPoints() + action.getPoints());
        }
        return userPoint;
    }

    private UserAction getUserAction(Long userID, Action action) {
        UserAction userAction = userActionRepository.findByUserIdAndAction(userID, action).orElse(null);
        if (userAction == null) {
            // We haven't seen this action for this user,
            // Let's create a new entry with count equal to 1
            userAction = new UserAction(userID, action, 1);
        } else {
            // We have seen this action for this user before
            // just increment the action counter
            userAction.setCount(userAction.getCount() + 1);
        }
        userActionRepository.save(userAction);
        return userAction;
    }
}
