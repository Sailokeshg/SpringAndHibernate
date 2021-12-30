package com.zemoso.springdemo.setterinjection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("com/zemoso/springdemo/resources/applicationContextSet.xml");
        Coach theCoach = context.getBean("tennisCoach", Coach.class);

        System.out.println(theCoach.getDailyWorkout());

        //Auto wiring is implemented here for constructor injection
        System.out.println(theCoach.getDailyFortune());

        //Auto wiring is implemented here for setter injection

        context.close();
    }
}
