package com.zemoso.springdemo.overview.dependencyinjection;

public class BaseballCoach implements Coach {

    private FortuneService fortuneService;

    public BaseballCoach(FortuneService theFortuneService) {
        fortuneService = theFortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Run around the ground";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();

    }
}
