package com.example.spring_boot.crud_demo.rest;

import com.example.spring_boot.crud_demo.dao.EmployeeDAO;
import com.example.spring_boot.crud_demo.entity.Employee;
import com.example.spring_boot.crud_demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeRestController {
    @Autowired
    private EmployeeService employeeService;

    //expose "/employees"  and return all employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }
   @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId){
        return employeeService.findById(employeeId);
   }
   @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);
        employeeService.save(employee);
        return employee;
   }
   @PutMapping("/employees/{employeeId}")
   public Employee updateEmployee(@RequestBody Employee employee,
                                  @PathVariable int employeeId){
       employee.setId(employeeId);
       employeeService.save(employee);
       return employee;
   }
   @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        employeeService.deleteById(employeeId);
        return "Deleted employee id- "+employeeId;
   }
}
