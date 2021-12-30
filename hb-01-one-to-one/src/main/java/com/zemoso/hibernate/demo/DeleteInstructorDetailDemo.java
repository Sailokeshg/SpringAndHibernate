package com.zemoso.hibernate.demo;

import com.zemoso.hibernate.demo.entity.Instructor;
import com.zemoso.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteInstructorDetailDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating a new student object..");


            session.beginTransaction();

            int theId =3;

            InstructorDetail tempInstructorDetail
                    = session.get(InstructorDetail.class,theId);
            System.out.println("tempInstructorDetail: "+ tempInstructorDetail);

            System.out.println("The associated instructor is: "+ tempInstructorDetail.getInstructor());

            //to delete instructor detail

            System.out.println("Deleting tempInstructorDetail: "+ tempInstructorDetail);

            //We have to remove the associated object reference
            //Break bi-directional link
            tempInstructorDetail.getInstructor().setInstructorDetail(null);

            session.delete(tempInstructorDetail);

            session.getTransaction().commit();

            System.out.println("Committed and Done");

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            //to handle connection leak
            session.close();
            factory.close();
        }

    }
}
