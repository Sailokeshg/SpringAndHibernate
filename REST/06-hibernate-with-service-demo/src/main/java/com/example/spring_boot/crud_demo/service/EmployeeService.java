package com.example.spring_boot.crud_demo.service;

import com.example.spring_boot.crud_demo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();
    public Employee findById(int id);
    public void save(Employee employee);
    public void deleteById(int id);
}
