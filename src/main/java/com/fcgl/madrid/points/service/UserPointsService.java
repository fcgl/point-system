package com.fcgl.madrid.points.service;

import com.fcgl.madrid.points.model.UserPoint;
import com.fcgl.madrid.points.repository.UserPointsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPointsService {
    private UserPointsRepository userPointsRepository;

    @Autowired
    public UserPointsService(UserPointsRepository userPointsRepository) {
        this.userPointsRepository = userPointsRepository;
    }

    public List<UserPoint> findAll() {
        return userPointsRepository.findAll();
    }
}
