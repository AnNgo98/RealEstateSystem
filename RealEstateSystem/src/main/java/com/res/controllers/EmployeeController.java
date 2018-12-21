package com.res.controllers;

import com.res.forms.LoginForm;
import com.res.models.Employee;
import com.res.models.Post;
import com.res.services.EmployeeService;
import com.res.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class EmployeeController {

    @Autowired
    private HttpSession httpSession;
    @Autowired
    private NotificationService notifyService;
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginAdmin(LoginForm loginForm) {
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String loginAdmin(@Valid LoginForm loginForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            notifyService.addErrorMessage("Please fill the form correctly!");
            return "login";
        }

        Employee admin = this.employeeService.findByUsernamePassword(loginForm.getUsername(), loginForm.getPassword());

        if (admin.getEmployee_ID() == 0) {
            notifyService.addErrorMessage("Username or password is incorrect!");
            return "login";
        }

        httpSession.setAttribute("Account", admin);
        notifyService.addInfoMessage("Login successful");
        return "redirect:/";
    }
}
