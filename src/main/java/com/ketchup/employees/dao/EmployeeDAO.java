package com.ketchup.employees.dao;

import com.ketchup.employees.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
