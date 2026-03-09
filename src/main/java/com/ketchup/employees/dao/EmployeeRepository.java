package com.ketchup.employees.dao;

import com.ketchup.employees.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //nothing else to do
}
