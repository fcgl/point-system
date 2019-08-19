package com.fcgl.madrid.points.service;

import com.fcgl.madrid.points.model.Action;
import com.fcgl.madrid.points.repository.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActionService {
    private ActionRepository actionRepository;

    @Autowired
    public ActionService(ActionRepository actionRepository) {
        this.actionRepository = actionRepository;
    }

    public List<Action> findAll() {
        return actionRepository.findAll();
    }
}

