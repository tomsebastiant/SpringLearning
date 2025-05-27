package com.tomsebastiant.springboot.demo.myspringapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

// inject properties for from application properties

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

// Adding endpoint for custom properties

    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return teamName + " is coached by " + coachName;
    }

//    Exposing a "/" endpoint that return hello world

    @GetMapping("/")
    public  String sayHello(){
        return "Hello World!";
    }

// expose new endpoint
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "cover 10k steps";
    }

    @GetMapping("/fortune")
    public String getDailyfortune(){
        return "Badluck";
    }

}
