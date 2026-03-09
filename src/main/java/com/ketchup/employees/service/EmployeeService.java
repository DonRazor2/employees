package com.ketchup.employees.service;

import com.ketchup.employees.entity.Employee;
import com.ketchup.employees.request.EmployeeRequest;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(final long id);

    Employee save(final EmployeeRequest employeeRequest);

    Employee update(final long id, final EmployeeRequest employeeRequest);

    Employee convertToEmployee(final long id, final EmployeeRequest employeeRequest);

    void deleteById(final long id);
}
