package com.zemoso.hibernate.demo;

import com.zemoso.hibernate.demo.entity.Instructor;
import com.zemoso.hibernate.demo.entity.InstructorDetail;
import com.zemoso.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating a new student object..");

           /* Instructor tempInstructor = new Instructor("Chad","Darby","darby@zemosolabs.com");

            InstructorDetail tempInstructorDetail
                    = new InstructorDetail("https://www.youtube.com","coding");*/
            Instructor tempInstructor = new Instructor("Sai","Lokesh","lokesh@zemosolabs.com");

            InstructorDetail tempInstructorDetail
                    = new InstructorDetail("https://www.linkedin.com","music");

            tempInstructor.setInstructorDetail(tempInstructorDetail);

            session.beginTransaction();

            System.out.println("Saving instructor "+ tempInstructor);
            session.save(tempInstructor);

            session.getTransaction().commit();

            System.out.println("Committed and Done");

        }
        finally {
            factory.close();
        }

    }
}
