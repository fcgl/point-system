package com.fcgl.madrid.points.controller;

import com.fcgl.madrid.points.dataModel.Trophy;
import com.fcgl.madrid.points.dataModel.UserAction;
import com.fcgl.madrid.points.payload.request.PostUserAction;
import com.fcgl.madrid.points.service.UserActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/points/user_action/v1")
public class UserActionController {
    private UserActionService userActionsService;

    @Autowired
    public void setPostService(UserActionService userActionsService) {
        this.userActionsService = userActionsService;
    }

    @GetMapping("/all")
    public List<UserAction> findAll() {
        return userActionsService.findAll();
    }

    @PostMapping("/addUserAction")
    public ResponseEntity<Trophy> AddUserAction(@Valid @RequestBody PostUserAction userAction) {
        return userActionsService.addUserAction(userAction);
    }
}
