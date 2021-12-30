package com.zemoso.springdemo.overview.inversionofcontrol;

public class BaseballCoach implements Coach {
    @Override
    public String getDailyWorkout(){
        return "Run around the ground";
    }
}
