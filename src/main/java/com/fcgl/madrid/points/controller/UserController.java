package com.fcgl.madrid.points.controller;

import com.fcgl.madrid.points.payload.response.Response;
import com.fcgl.madrid.points.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/points/user/v1")
public class UserController {

    private UserService userService;

    @Autowired
    public void setPostService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/summary")
    public ResponseEntity<Response> getUserData(@NotNull Long userId) {
        return userService.getUserData(userId);
    }


}
