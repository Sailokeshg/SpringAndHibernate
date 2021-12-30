package com.zemoso.springdemo.annotationscope;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("com/zemoso/springdemo/resources/applicationContextAnnScope.xml");

        Coach theCoach = context.getBean("tennisCoach", Coach.class);

        Coach alphaCoach = context.getBean("tennisCoach", Coach.class);

        boolean isSame = (theCoach == alphaCoach);

        System.out.println("Is poiniting to same object: " + isSame);
        System.out.println("\n Memory location for theCoach: " + theCoach);
        System.out.println("\n Memory location for alphaCoach: " + alphaCoach);

    }
}
