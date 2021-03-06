package com.zemoso.hibernate.demo;

import com.zemoso.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import  org.hibernate.cfg.Configuration;



public class CreateStudentDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating a new student object..");

            Student tempStudent = new Student("John","Doe","john@zemosolabs.com");

            session.beginTransaction();
            System.out.println("saving the student in db");
            session.save(tempStudent);
            session.getTransaction().commit();

            System.out.println("Committed and Done");

        }
        finally {
            factory.close();
        }

    }
}
