package com.fcgl.madrid.points.controller;

import com.fcgl.madrid.points.model.Action;
import com.fcgl.madrid.points.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/points/action/v1")
public class ActionController {
    private ActionService actionService;

    @Autowired
    public void setPostService(ActionService actionService) {
        this.actionService = actionService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Action> findAll() {
        return actionService.findAll();
    }
}
