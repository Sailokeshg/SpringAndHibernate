package com.zemoso.springdemo.setterinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
    private FortuneService fortuneService;

    public TennisCoach(){
        System.out.println("Tennis Coach: Inside default constructor");
    }
    @Autowired
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("Tennis coach: inside setFortuneService() method");
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice special shots";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
