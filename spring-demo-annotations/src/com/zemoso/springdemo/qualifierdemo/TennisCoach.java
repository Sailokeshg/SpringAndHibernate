package com.zemoso.springdemo.qualifierdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    @Autowired
    @Qualifier("randomFortuneService")
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
