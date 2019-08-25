package com.fcgl.madrid.points.controller;

import com.fcgl.madrid.points.model.Action;
import com.fcgl.madrid.points.service.ActionPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/points/actionPoint/v1")
public class ActionPointController {
    private ActionPointService actionPointService;

    @Autowired
    public void setPostService(ActionPointService actionPointService) {
        this.actionPointService = actionPointService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Action> findAll() {
        return actionPointService.findAll();
    }
}
