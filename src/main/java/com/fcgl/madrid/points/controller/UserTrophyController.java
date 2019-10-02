package com.fcgl.madrid.points.controller;

import com.fcgl.madrid.points.model.response.GetUserTrophyResponse;
import com.fcgl.madrid.points.model.UserTrophy;
import com.fcgl.madrid.points.service.UserTrophyService;
import com.fcgl.madrid.points.repository.UserTrophyRepository;
import com.fcgl.madrid.points.model.InternalStatus;
import com.fcgl.madrid.dev.DevService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/points/user_trophies/v1")
public class UserTrophyController {
    private UserTrophyService userTrophyService;

    DevService devService;

    @GetMapping("/userTrophies")
    public ResponseEntity<GetUserTrophyResponse> getUserTrophiesById(Long userId) {
        return userTrophyService.getUserTrophiesById(userId);
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
