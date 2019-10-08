package com.fcgl.madrid.dev;

import com.fcgl.madrid.points.dataModel.*;
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
    private UserPointHistoryRepository userPointHistoryRepository;
    private UserPointsRepository userPointsRepository;
    private UserTrophyRepository userTrophyRepository;

    @Autowired
    public DataPopulation(ActionRepository actionRepository,
                          TrophyRepository trophyRepository,
                          UserPointHistoryRepository userPointHistoryRepository,
                          UserPointsRepository userPointsRepository,
                          UserTrophyRepository userTrophyRepository) {
        this.actionRepository = actionRepository;
        this.trophyRepository = trophyRepository;
        this.userPointHistoryRepository = userPointHistoryRepository;
        this.userPointsRepository = userPointsRepository;
        this.userTrophyRepository = userTrophyRepository;
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
        Trophy trophy = new Trophy(100, "/no/where", "King of Receipts", addingAReceipt, 3, "baby_bottle");
        Trophy trophy2 = new Trophy(100, "/no/where", "King of Popcorn", addingAReceipt, 2, "popcorn");
        Trophy trophy3 = new Trophy(50, "/no/where", "King of Forum", addingAReceipt, 2, "ribbon");
        Trophy trophy4 = new Trophy(25, "/no/where", "King of Toast", addingAReceipt, 2, "balloon");
        trophyRepository.save(trophy);
        trophyRepository.save(trophy2);
        trophyRepository.save(trophy3);
        trophyRepository.save(trophy4);

        UserTrophy userTrophy = new UserTrophy(1L, trophy, 1);
        UserTrophy userTrophy2 = new UserTrophy(1L, trophy2, 1);
        UserTrophy userTrophy3 = new UserTrophy(1L, trophy3, 1);
        UserTrophy userTrophy4 = new UserTrophy(1L, trophy4, 1);
        userTrophyRepository.save(userTrophy);
        userTrophyRepository.save(userTrophy2);
        userTrophyRepository.save(userTrophy3);
        userTrophyRepository.save(userTrophy4);


        UserPoint userPoint = new UserPoint(1L, 100,  50);

        userPointsRepository.save(userPoint);
        
        UserPointHistory userPointHistory = new UserPointHistory(new Long(1), addingAReceipt, "Receipt from: Food Lion");
        UserPointHistory userPointHistory2 = new UserPointHistory(new Long(1), recommendingToAFriend, "Thank you for the referral");

        userPointHistoryRepository.save(userPointHistory);
        userPointHistoryRepository.save(userPointHistory2);
    }
}
