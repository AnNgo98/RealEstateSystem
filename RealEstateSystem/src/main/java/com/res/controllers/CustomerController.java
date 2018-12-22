package com.res.controllers;

import com.res.models.Customer;
import com.res.repositories.CustomerRepository;
import com.res.services.CustomerService;
import com.res.services.NotificationService;
import com.res.services.PostService;
import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class CustomerController {


    @Autowired
    private NotificationService notifyService;
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/customers/create")
    public String createCustomer(Customer customer) {
        return "Customers/AddCustomer";
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
    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public String index(Model model){
        List<Customer> lstCus = customerService.findAll();
        model.addAttribute(lstCus);
        return "customers/IndexCustomer";
    }
}
