package com.res.services;

import com.res.models.Customer;
import com.res.models.Employee;
import com.res.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepo;

    @Override
    public List<Customer> findAll() {
        return this.customerRepo.findAll();
    }

    @Override
    public List<Customer> findByName(String name) {
        return (List<Customer>) this.customerRepo.findAll().stream().filter(p -> p.getFullname().contains(name));
    }

    @Override
    public List<Customer> findByUsername(String username) {
        return (List<Customer>) this.customerRepo.findAll().stream().filter(p -> p.getAccount().getUserName().contains(username));
    }

    @Override
    public boolean createOrUpdate(Customer customer) {
        try {
            this.customerRepo.save(customer);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
