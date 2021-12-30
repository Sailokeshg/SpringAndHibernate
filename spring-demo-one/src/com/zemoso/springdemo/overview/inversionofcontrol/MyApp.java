package com.zemoso.springdemo.overview.inversionofcontrol;

public class MyApp {
    public static void main(String[] args) {
        Coach baseballCoach = new BaseballCoach();
    //    Coach cricketCoach = new CricketCoach();
        System.out.println(baseballCoach.getDailyWorkout());
    }
}
