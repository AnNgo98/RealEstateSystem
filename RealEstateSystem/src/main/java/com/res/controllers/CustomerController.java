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

    @RequestMapping("/customer/create")
    public String createCustomer(Customer customer) {
        return "customer/create";
    }

    @RequestMapping(value = "/customer/create", method = RequestMethod.POST)
    public String createCustomer(@Valid Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            notifyService.addErrorMessage("Please fill the form correctly!");
            return "customer/create";
        }

        if (!customerService.create(customer)) {
            notifyService.addErrorMessage("Invalid create!");
            return "customer/create";
        }

        notifyService.addInfoMessage("Create successful");
        return "redirect:/customer/create";
    }
}
