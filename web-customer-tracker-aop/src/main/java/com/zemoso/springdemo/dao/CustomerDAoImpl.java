package com.zemoso.springdemo.dao;

import com.zemoso.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAoImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {

        Session currentSession = sessionFactory.getCurrentSession();

        Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName ",Customer.class);

        //execute query and get result list
        List<Customer> customers = theQuery.getResultList();

        return customers;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {

        //get session and save data to db

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.saveOrUpdate(theCustomer);

    }

    @Override
    public Customer getCustomer(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();

        Customer theCustomer = currentSession.get(Customer.class,theId);

        return theCustomer;
    }

    @Override
    public void deleteCustomer(int theId) {

        Session currentSession = sessionFactory.getCurrentSession();

        Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");

        theQuery.setParameter("customerId",theId);

        theQuery.executeUpdate();

    }
}
