package com.fcgl.madrid.points.controller;

import com.fcgl.madrid.points.model.Trophy;
import com.fcgl.madrid.points.service.TrophyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Trophy> findAll() {
        return trophyService.findAll();
    }
}
