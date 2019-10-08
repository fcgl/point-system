package com.fcgl.madrid.points.controller;

import com.fcgl.madrid.points.payload.request.UserId;
import com.fcgl.madrid.points.payload.response.GetUserTrophyResponse;
import com.fcgl.madrid.points.dataModel.UserTrophy;
import com.fcgl.madrid.points.service.UserTrophyService;
import com.fcgl.madrid.dev.DevService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/points/user_trophies/v1")
public class UserTrophyController {
    private UserTrophyService userTrophyService;

    DevService devService;

    @GetMapping("/userTrophies")
    public ResponseEntity<GetUserTrophyResponse> getUserTrophiesById(@Valid UserId userId) {
        return userTrophyService.getUserTrophiesById(userId.getUserId());
    }

    @Autowired
    public void setPostService(UserTrophyService userTrophyService) {
        this.userTrophyService = userTrophyService;
    }

    @GetMapping("/all")
    public List<UserTrophy> findAll() {
        return userTrophyService.findAll();
    }
}
