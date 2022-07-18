package com.iapl.robots.service;

import com.iapl.robots.pojos.Robot;
import com.iapl.robots.util.RobotApiUtil;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RobotService {

    @Value("${robots.url}")
    private String robotsUrl;

    public List<Robot> getAllRobots() throws UnirestException {
        return RobotApiUtil.fetchRobots(robotsUrl);
    }

}
