package com.ketchup.employees.dao;

import com.ketchup.employees.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(final long id);

    Employee save(final Employee employee);

    void deleteById(final long id);
}
