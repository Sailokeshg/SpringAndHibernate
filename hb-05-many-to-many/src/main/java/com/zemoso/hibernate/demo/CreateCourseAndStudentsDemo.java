package com.zemoso.hibernate.demo;

import com.zemoso.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCourseAndStudentsDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            Course tempCourse = new Course("Pacman -How to score High");



            System.out.println("\nSaving the course: "+tempCourse);
            session.save(tempCourse);
            System.out.println("Saved the course: "+tempCourse);

            Student tempStudent1 = new Student("John","Doe","John@zemosolabs.com");
            Student tempStudent2 = new Student("Mary","Public","John@zemosolabs.com");

            tempCourse.addStudent(tempStudent1);
            tempCourse.addStudent(tempStudent2);

            System.out.println("\n Saving students...");
            session.save(tempStudent1);
            session.save(tempStudent2);
            System.out.println("Students saved: "+tempCourse.getStudents());

            session.getTransaction().commit();

            System.out.println("Committed and Done");

        }
        finally {
            session.close();
            factory.close();
        }

    }
}
