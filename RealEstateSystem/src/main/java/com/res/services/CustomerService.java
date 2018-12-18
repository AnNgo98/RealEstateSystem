package com.res.services;

import com.res.models.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    List<Customer> findByName(String name);
    List<Customer> findByUsername(String username);
    boolean createOrUpdate(Customer customer);
}
