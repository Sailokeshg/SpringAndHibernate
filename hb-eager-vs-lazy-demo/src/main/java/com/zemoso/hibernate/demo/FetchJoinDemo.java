package com.zemoso.hibernate.demo;

import com.zemoso.hibernate.demo.entity.Course;
import com.zemoso.hibernate.demo.entity.Instructor;
import com.zemoso.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class FetchJoinDemo {
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

            Query<Instructor> query = session.createQuery("select i from Instructor i "+
                    "JOIN FETCH i.courses "+
                    "where i.id=:theInstructorId",
                    Instructor.class);

            //set parameter on query
            query.setParameter("theInstructorId",theId);

            //execute query and get instructor
            Instructor tempInstructor = query.getSingleResult();

            System.out.println("OUr Instructor: "+tempInstructor);

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
