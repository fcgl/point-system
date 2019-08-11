package com.fcgl.madrid.points.controller;

import com.fcgl.madrid.points.model.UserPoints;
import com.fcgl.madrid.points.service.UserPointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/points/user_points/v1")
public class UserPointsController {
    private UserPointsService userPointsService;

    @Autowired
    public void setPostService(UserPointsService userPointsService) {
        this.userPointsService = userPointsService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<UserPoints> findAll() {
        return userPointsService.findAll();
    }
}
