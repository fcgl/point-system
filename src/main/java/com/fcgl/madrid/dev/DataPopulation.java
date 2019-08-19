package com.fcgl.madrid.dev;

import com.fcgl.madrid.points.model.*;
import com.fcgl.madrid.points.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

// TODO: replace with tests
@Service
public class DataPopulation {

    private ActionRepository actionRepository;
    private TrophyRepository trophyRepository;
    private UserActionRepository userActionRepository;
    private UserPointsRepository userPointsRepository;
    private UserTrophyRepository userTrophyRepository;

    @Autowired
    public DataPopulation(ActionRepository actionRepository,
                          TrophyRepository trophyRepository,
                          UserActionRepository userActionRepository,
                          UserPointsRepository userPointsRepository,
                          UserTrophyRepository userTrophyRepository) {
        this.actionRepository = actionRepository;
        this.trophyRepository = trophyRepository;
        this.userActionRepository = userActionRepository;
        this.userPointsRepository = userPointsRepository;
        this.userTrophyRepository = userTrophyRepository;
    }

    @Transactional
    @PostConstruct
    public void init() {
        long userId = 99;
        UserPoint userPoints = new UserPoint(userId, 10, 5);
        userPointsRepository.save(userPoints);

        Action action = new Action("Adding a receipt");
        actionRepository.save(action);

        UserAction userAction = new UserAction(userId, action, 10);
        userActionRepository.save(userAction);

        Trophy trophy = new Trophy(10, "/no/where", "King of Receipts", action, 10);
        trophyRepository.save(trophy);

        UserTrophy userTrophy = new UserTrophy(userId, trophy);
        userTrophyRepository.save(userTrophy);
    }
}
