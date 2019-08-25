package com.fcgl.madrid.points.service;

import com.fcgl.madrid.points.model.Action;
import com.fcgl.madrid.points.repository.ActionPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActionPointService {

    private ActionPointRepository actionPointRepository;

    @Autowired
    public ActionPointService(ActionPointRepository actionPointRepository) {
        this.actionPointRepository = actionPointRepository;
    }

    public List<Action> findAll() {
        return actionPointRepository.findAll();
    }
}
