package com.zemoso.springdemo.overview.beanscope;

public class MyApp {
    public static void main(String[] args) {
       Coach baseballCoach = new TrackCoach();
       System.out.println(baseballCoach.getDailyWorkout());
    }
}