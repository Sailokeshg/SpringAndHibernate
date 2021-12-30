package com.example.spring_boot.crud_demo.dao;

import com.example.spring_boot.crud_demo.entity.Employee;
import com.example.spring_boot.crud_demo.exception.EmployeeNotFoundException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
    //  define field for entitymanager
    private final EntityManager entityManager;
    //set up constructor injection
    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override

    public List<Employee> findAll() {

        //get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);
        // create query
        Query<Employee> query = currentSession.createQuery(
                "from Employee",Employee.class
        );
        //execute query and get result list
        List<Employee> employees = query.getResultList();
        //return result
        return employees;
    }

    @Override

    public Employee findById(int id) {
        //get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);
        // get employee
        Employee employee = currentSession.get(Employee.class,id);
        if(employee==null)
            throw new EmployeeNotFoundException("Employee id not found -"+id);
        //return result
        return employee;
    }

    @Override

    public void save(Employee employee) {
        Session currentSession = entityManager.unwrap(Session.class);
        //save employee
        currentSession.saveOrUpdate(employee);

    }

    @Override

    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        //delete employee
        Employee employee = findById(id);
        currentSession.delete(employee);
    }
}
