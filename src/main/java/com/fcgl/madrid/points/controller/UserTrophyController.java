package com.fcgl.madrid.points.controller;

import com.fcgl.madrid.points.model.UserTrophy;
import com.fcgl.madrid.points.service.UserTrophyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/points/user_trophies/v1")
public class UserTrophyController {
    private UserTrophyService userTrophiesService;

    @Autowired
    public void setPostService(UserTrophyService userTrophiesService) {
        this.userTrophiesService = userTrophiesService;
    }

    @GetMapping("/all")
    public List<UserTrophy> findAll() {
        return userTrophiesService.findAll();
    }
}
