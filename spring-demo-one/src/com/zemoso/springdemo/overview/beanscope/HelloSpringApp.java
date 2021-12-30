package com.zemoso.springdemo.overview.beanscope;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {
    public static void main(String[] args) {
        //loading config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("overview/applicationContextDin.xml");
        //retrieve the beans from container
        Coach theCoach = context.getBean("myCoach", Coach.class);

        System.out.println(theCoach.getDailyWorkout());

        System.out.println(theCoach.getDailyFortune());

        context.close();
    }
}
