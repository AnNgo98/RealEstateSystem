package com.res.services;

import com.res.config.PasswordEncoder;
import com.res.models.Customer;
import com.res.models.Employee;
import com.res.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Employee> findAll() {
        return this.employeeRepo.findAll();
    }

    @Override
    public List<Employee> findByName(String name) {
        return (List<Employee>) this.employeeRepo.findAll().stream().filter(p -> p.getFullname().contains(name));
    }

    @Override
    public List<Employee> findByUsername(String username) {
        return (List<Employee>) this.employeeRepo.findAll().stream().filter(p -> p.getAccount().getUserName().contains(username));
    }

    @Override
    public List<Employee> findByEmail(String email) {
        return (List<Employee>) this.employeeRepo.findAll().stream().filter(p -> p.getEmail().contains(email));
    }

    @Override
    public boolean createOrUpdate(Employee employee) {
        try {
            this.employeeRepo.save(employee);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Employee findByUsernamePassword(String username, String password) {

        Employee employee = this.employeeRepo.findAll().stream().filter(p -> Objects.equals(p.getAccount().getUserName(), username)).findFirst()
                .orElse(null);

        String ash = passwordEncoder.hashPassword(password);

        if(employee == null || !passwordEncoder.checkPassword(password, employee.getAccount().getPassword())){
            return new Employee();
        }

        return employee;
    }
}
