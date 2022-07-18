package com.iapl.robots.util;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iapl.robots.pojos.Robot;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.List;

public class RobotApiUtil {


    public static List<Robot> fetchRobots(String url) throws UnirestException {
        HttpResponse<String> response = Unirest.get(url).asString();
        if (response.getStatus() == 200) {
            String resp = response.getBody();
            Gson gson = new Gson();
            List<Robot> robots = gson.fromJson(resp, new TypeToken<List<Robot>>(){}.getType());
            return robots;
        } else {
            return null;
        }
    }

}
