package com.zemoso.springdemo.annotationscope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
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
