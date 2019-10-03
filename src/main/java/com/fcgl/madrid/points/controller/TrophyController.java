package com.fcgl.madrid.points.controller;

import com.fcgl.madrid.points.dataModel.Trophy;
import com.fcgl.madrid.points.service.TrophyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/points/trophy/v1")
public class TrophyController {
    private TrophyService trophyService;

    @Autowired
    public void setPostService(TrophyService trophyService) {
        this.trophyService = trophyService;
    }

    @GetMapping("/all")
    public List<Trophy> findAll() {
        return trophyService.findAll();
    }
}
