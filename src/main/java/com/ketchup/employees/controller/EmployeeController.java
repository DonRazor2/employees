package com.ketchup.employees.controller;

import com.ketchup.employees.dao.EmployeeDAO;
import com.ketchup.employees.entity.Employee;
import com.ketchup.employees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @GetMapping
    public List<Employee> findAll() {
        return employeeService.findAll();
    }
}
