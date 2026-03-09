package com.ketchup.employees.controller;

import com.ketchup.employees.EmployeesApplication;
import com.ketchup.employees.entity.Employee;
import com.ketchup.employees.request.EmployeeRequest;
import com.ketchup.employees.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@Tag(name = "Employee REST operations", description = "Operations related to employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @Operation(summary = "Get all employees", description = "Retrieve the list of employees")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @Operation(summary = "Get an employee", description = "Fetch an employee from the database")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{employeeID}")
    public Employee findById(@PathVariable @Min(value = 1) long employeeID) {
        return employeeService.findById(employeeID);
    }

    @Operation(summary = "Add an employee", description = "Add a new employee into the database")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Employee addEmployee(final @Valid @RequestBody EmployeeRequest employeeRequest) {
        return employeeService.save(employeeRequest);
    }

    @Operation(summary = "Update an employee", description = "Update the details of an employee into the database")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{employeeID}")
    public Employee updateEmployee(@PathVariable @Min(1) long employeeID,
                                   @Valid @RequestBody EmployeeRequest employeeRequest) {
        return employeeService.update(employeeID, employeeRequest);
    }

    @Operation(summary = "Delete an employee", description = "Delete an employee from the database")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{employeeID}")
    public void updateEmployee(@PathVariable @Min(1) long employeeID) {
        employeeService.deleteById(employeeID);
    }
}
