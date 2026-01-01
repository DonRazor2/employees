package com.ketchup.employees.service;

import com.ketchup.employees.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(final int id);

}
