package com.fcgl.madrid.dev;

import com.fcgl.madrid.points.model.Action;
import com.fcgl.madrid.points.model.Trophy;
import com.fcgl.madrid.points.repository.ActionRepository;
import com.fcgl.madrid.points.repository.TrophyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

// TODO: replace with tests
@Service
public class DataPopulation {

    private ActionRepository actionRepository;
    private TrophyRepository trophyRepository;

    @Autowired
    public DataPopulation(ActionRepository actionRepository,
                          TrophyRepository trophyRepository) {
        this.actionRepository = actionRepository;
        this.trophyRepository = trophyRepository;
    }

    @Transactional
    @PostConstruct
    public void init() {
        // Action #1
        Action addingAReceipt = new Action("Adding a receipt");
        actionRepository.save(addingAReceipt);

        // Action #2
        Action recommendingToAFriend = new Action("Recommending to a friend");
        actionRepository.save(recommendingToAFriend);

        // Trophy #1, the user has to do action #1 x3 times to earn this trophy
        Trophy trophy = new Trophy(100, "/no/where", "King of Receipts", addingAReceipt, 3);
        trophyRepository.save(trophy);
    }
}
