package com.zemoso.springdemo.fieldinjection;

//import com.zemoso.springdemo.anymethodinjection.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("com/zemoso/springdemo/resources/applicationContextFld.xml");
        Coach theCoach = context.getBean("tennisCoach", Coach.class);

        System.out.println(theCoach.getDailyWorkout());

        //Auto wiring is implemented here for constructor injection
        System.out.println(theCoach.getDailyFortune());

        //Auto wiring is implemented here for setter injection

        context.close();
    }
}
