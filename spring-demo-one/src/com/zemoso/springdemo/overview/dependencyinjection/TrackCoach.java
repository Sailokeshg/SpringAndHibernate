package com.zemoso.springdemo.overview.dependencyinjection;

public class TrackCoach implements Coach {

    private FortuneService fortuneService;
    public TrackCoach(){

    }

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Make 20 squats";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
