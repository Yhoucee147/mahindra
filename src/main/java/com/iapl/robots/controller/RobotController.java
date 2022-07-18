package com.iapl.robots.controller;

import com.iapl.robots.pojos.Robot;
import com.iapl.robots.service.RobotService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/robot")
public class RobotController {

    @Autowired
    private RobotService robotService;

    @GetMapping("/getAllRobots")
    public List<Robot> getAllRobots() throws UnirestException {
        return robotService.getAllRobots();
    }

}
