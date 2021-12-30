package com.zemoso.hibernate.demo;

import com.zemoso.hibernate.demo.entity.Course;
import com.zemoso.hibernate.demo.entity.Instructor;
import com.zemoso.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class EagerLazyDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            int theId =1;
            Instructor tempInstructor = session.get(Instructor.class,theId);

            System.out.println("OUr Instructor: "+tempInstructor);

            System.out.println("OUr Courses: "+tempInstructor.getCourses());

            session.getTransaction().commit();

            session.close();

            System.out.println("\nThe session is now closed\n");
            System.out.println("OUr Courses: "+tempInstructor.getCourses());

            System.out.println("Committed and Done");

        }
        finally {

            factory.close();
        }

    }
}
