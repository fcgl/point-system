package com.fcgl.madrid.points.service;

import com.fcgl.madrid.points.model.UserAction;
import com.fcgl.madrid.points.repository.UserActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserActionService {
    private UserActionRepository userActionRepository;

    @Autowired
    public UserActionService(UserActionRepository userActionRepository) {
        this.userActionRepository = userActionRepository;
    }

    public List<UserAction> findAll() {
        return userActionRepository.findAll();
    }
}
