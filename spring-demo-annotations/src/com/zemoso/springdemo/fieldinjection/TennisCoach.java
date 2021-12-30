package com.zemoso.springdemo.fieldinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    @Autowired
    private FortuneService fortuneService;

    public TennisCoach(){
        System.out.println("Tennis Coach: Inside default constructor");
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
