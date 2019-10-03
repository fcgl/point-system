package com.fcgl.madrid.points.service;

import com.fcgl.madrid.points.dataModel.Trophy;
import com.fcgl.madrid.points.repository.TrophyRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class TrophyService {
    private TrophyRepository trophyRepository;

    @Autowired
    public TrophyService(TrophyRepository trophyRepository) {
        this.trophyRepository = trophyRepository;
    }

    public List<Trophy> findAll() {
        return trophyRepository.findAll();
    }
}
