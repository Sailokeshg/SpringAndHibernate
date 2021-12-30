package com.zemoso.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FunRestController {

    //inject coach props from properties file
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "Coach: "+coachName+", Team name: "+teamName;
    }
    @GetMapping("/")
        public String sayHello(){
        return "Time server is: "+ LocalDateTime.now();
        }
        @GetMapping("/workout")
        public String getDailyWorkout(){
        return "Run  hard !";
        }

    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "Today is lucky day!";
    }




}


