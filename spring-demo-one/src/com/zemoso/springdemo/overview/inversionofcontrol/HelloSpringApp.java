package com.zemoso.springdemo.overview.inversionofcontrol;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {
    public static void main(String[] args) {
        //loading config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("resources/overview/applicationContextIoc.xml");
        //retrieve the beans from container
        Coach theCoach = context.getBean("myCoach", Coach.class);
        System.out.print(theCoach.getDailyWorkout());

        context.close();
    }
}
