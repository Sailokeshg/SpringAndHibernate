package com.zemoso.hibernate.demo;

import com.zemoso.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class QueryStudentDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            List<Student> theStudents = session.createQuery("from Student").getResultList();

            displayStudents(theStudents);


            //student with last name 'Doe'
            
            theStudents= session.createQuery("from Student s where s.lastName='Doe'").getResultList();
            System.out.println("students with last name 'Doe'");

            displayStudents(theStudents);

            theStudents = session.createQuery("from Student s where " +
                    " s.firstName='Daffy' OR s.lastName = 'Doe' ").getResultList();

            System.out.println("Students with first name of Daffy or last name of Doe");
            displayStudents(theStudents);

            theStudents = session.createQuery("from Student s where s.email LIKE '%zemosolabs.com'")
                    .getResultList();
            System.out.println("Students whose email end with zemosolabs.com");
            displayStudents(theStudents );

            session.getTransaction().commit();

            System.out.println("Committed and Done");

        }
        finally {
            factory.close();
        }

    }

    private static void displayStudents(List<Student> theStudents) {
        for(Student tempStudent: theStudents ){
            System.out.println(tempStudent);
        }
    }
}
