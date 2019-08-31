package com.fcgl.madrid.points.controller;

import com.fcgl.madrid.points.model.UserPoint;
import com.fcgl.madrid.points.service.UserPointsService;
import com.fcgl.madrid.points.model.InternalStatus;
import com.fcgl.madrid.dev.DevService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import com.fcgl.madrid.points.model.UserPoint;

import java.util.List;

@RestController
@RequestMapping("/points/user_points/v1")
public class UserPointsController {
    private UserPointsService userPointsService;

    DevService devService;

    @Autowired
    public void setPostService(UserPointsService userPointsService) {
        this.userPointsService = userPointsService;
    }

    @GetMapping("/all")
    public List<UserPoint> findAll() {
        return userPointsService.findAll();
    }

    @GetMapping(value="/fallback")
    public ResponseEntity<InternalStatus> failureWithFallback() {
        return devService.failureWithFallback();
    }

}
