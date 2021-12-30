package com.zemoso.springdemo.definebeanwithjava;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach{

    private FortuneService fortuneService;

    @Value("${coach.email}")
    private String email;

    @Value("${coach.team}")
    private String team;

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }

    public SwimCoach(FortuneService theFortuneService){
        fortuneService=theFortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 1000 meters";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
