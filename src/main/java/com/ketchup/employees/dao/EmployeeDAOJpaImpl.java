package com.ketchup.employees.dao;

import com.ketchup.employees.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    private final EntityManager entityManager;

    public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        // Create a query
        final TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);

        // Return the results
        return query.getResultList();
    }

    @Override
    public Employee findById(long id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee save(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public void deleteById(long id) {
        final Employee theEmployee = entityManager.find(Employee.class, id);

        entityManager.remove(theEmployee);
    }
}
