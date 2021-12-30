package com.zemoso.springdemo.javaannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TennisCoach implements Coach {

    @Autowired
    private FortuneService fortuneService;

    public TennisCoach(){
        System.out.println("Tennis Coach: Inside default constructor");
    }

    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("TennisCoach : Inside of doMyStartupStuff");
    }

    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println("TennisCoach : Inside of doMyCleanupStuff");
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
