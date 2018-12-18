package com.res.services;

import com.res.models.Employee;
import com.res.models.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    List<Employee> findByName(String name);
    List<Employee> findByUsername(String username);
    List<Employee> findByEmail(String email);
    boolean createOrUpdate(Employee employee);

    Employee findByUsernamePassword(String username, String password);
}
