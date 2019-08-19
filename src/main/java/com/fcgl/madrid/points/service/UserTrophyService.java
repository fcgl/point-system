package com.fcgl.madrid.points.service;

import com.fcgl.madrid.points.model.UserTrophy;
import com.fcgl.madrid.points.repository.UserTrophyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTrophyService {
    private UserTrophyRepository userTrophyRepository;

    @Autowired
    public UserTrophyService(UserTrophyRepository userTrophyRepository) {
        this.userTrophyRepository = userTrophyRepository;
    }

    public List<UserTrophy> findAll() {
        return userTrophyRepository.findAll();
    }
}
