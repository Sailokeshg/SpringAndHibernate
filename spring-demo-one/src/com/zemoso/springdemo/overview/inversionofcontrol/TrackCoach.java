package com.zemoso.springdemo.overview.inversionofcontrol;

public class TrackCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Make 20 squats";
    }
}
