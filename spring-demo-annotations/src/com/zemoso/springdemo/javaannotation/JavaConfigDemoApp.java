package com.zemoso.springdemo.javaannotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {
    public static void main(String[] args) {
       AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        Coach theCoach = context.getBean("tennisCoach", Coach.class);

        System.out.println(theCoach.getDailyWorkout());

        //Auto wiring is implemented here for constructor injection
        System.out.println(theCoach.getDailyFortune());

        //Auto wiring is implemented here for setter injection

        context.close();
    }
}
