package com.zemoso.springdemo.overview.setterinjection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("resources/overview/applicationContextSet.xml");
        CricketCoach theCoach  =context.getBean("myCricketCoach",CricketCoach.class);

        System.out.println(theCoach.getDailyWorkout());

        System.out.println(theCoach.getDailyFortune());

        //Testing literal value injection in setters
        System.out.println(theCoach.getEmailAddress());
        System.out.println(theCoach.getTeam());
        context.close();
    }
}
