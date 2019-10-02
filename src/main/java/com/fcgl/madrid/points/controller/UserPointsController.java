package com.fcgl.madrid.points.controller;

import com.fcgl.madrid.points.model.UserPoint;
import com.fcgl.madrid.points.model.response.GetUserPointsResponse;
import com.fcgl.madrid.points.service.UserPointsService;
import com.fcgl.madrid.dev.DevService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/points/user_points/v1")
public class UserPointsController {
    private UserPointsService userPointsService;
    private GetUserPointsResponse getUserPointResponse;

    DevService devService;

    @GetMapping("/userPoints")
    public ResponseEntity<GetUserPointsResponse> getUserPointsById(Long userId) {
        return userPointsService.getUserPointsById(userId);
    }

    @Autowired
    public void setPostService(UserPointsService userPointsService) {
        this.userPointsService = userPointsService;
    }

    @GetMapping("/all")
    public List<UserPoint> findAll() {
        return userPointsService.findAll();
    }


}
