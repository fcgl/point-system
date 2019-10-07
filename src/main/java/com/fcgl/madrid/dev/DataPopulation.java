package com.fcgl.madrid.dev;

import com.fcgl.madrid.points.dataModel.*;
import com.fcgl.madrid.points.repository.ActionRepository;
import com.fcgl.madrid.points.repository.TrophyRepository;
import com.fcgl.madrid.points.repository.UserPointHistoryRepository;
import com.fcgl.madrid.points.repository.UserPointsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

// TODO: replace with tests
@Service
public class DataPopulation {

    private ActionRepository actionRepository;
    private TrophyRepository trophyRepository;
    private UserPointHistoryRepository userPointHistoryRepository;
    private UserPointsRepository userPointsRepository;

    @Autowired
    public DataPopulation(ActionRepository actionRepository,
                          TrophyRepository trophyRepository,
                          UserPointHistoryRepository userPointHistoryRepository,
                          UserPointsRepository userPointsRepository) {
        this.actionRepository = actionRepository;
        this.trophyRepository = trophyRepository;
        this.userPointHistoryRepository = userPointHistoryRepository;
        this.userPointsRepository = userPointsRepository;
    }

    @Transactional
    @PostConstruct
    public void init() {
        // Action #1
        Action addingAReceipt = new Action(PointType.RECEIPT_UPLOAD, 5);
        actionRepository.save(addingAReceipt);

        // Action #2
        Action recommendingToAFriend = new Action(PointType.FRIEND_REFFERAL, 10);
        actionRepository.save(recommendingToAFriend);

        // Trophy #1, the user has to do action #1 x3 times to earn this trophy
        Trophy trophy = new Trophy(100, "/no/where", "King of Receipts", addingAReceipt, 3);
        trophyRepository.save(trophy);


        UserPoint userPoint = new UserPoint(1L, 100,  50);

        userPointsRepository.save(userPoint);
        
        UserPointHistory userPointHistory = new UserPointHistory(new Long(1), addingAReceipt, "Receipt from: Food Lion");
        UserPointHistory userPointHistory2 = new UserPointHistory(new Long(1), recommendingToAFriend, "Thank you for the referral");

        userPointHistoryRepository.save(userPointHistory);
        userPointHistoryRepository.save(userPointHistory2);
    }
}
