package com.res.controllers;

import com.res.models.Customer;
import com.res.services.CustomerService;
import com.res.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

public class CustomerController {


    @Autowired
    private NotificationService notifyService;
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/customers/create")
    public String createCustomer(Customer customer) {
        return "customers/create";
    }

    @RequestMapping(value = "/customers/create", method = RequestMethod.POST)
    public String createCustomer(@Valid Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            notifyService.addErrorMessage("Please fill the form correctly!");
            return "customers/create";
        }

        if (!customerService.createOrUpdate(customer)) {
            notifyService.addErrorMessage("Invalid create!");
            return "customers/create";
        }

        notifyService.addInfoMessage("Create successful");
        return "redirect:/customers/create";
    }
}
