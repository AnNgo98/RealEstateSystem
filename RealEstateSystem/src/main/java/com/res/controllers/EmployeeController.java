package com.res.controllers;

import com.res.forms.LoginForm;
import com.res.models.Account;
import com.res.models.Customer;
import com.res.models.Employee;
import com.res.models.Post;
import com.res.services.AccountService;
import com.res.services.EmployeeService;
import com.res.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private HttpSession httpSession;
    @Autowired
    private NotificationService notifyService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginAdmin(LoginForm loginForm) {
        return "login";
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public String viewEmp(Model model) {
        List<Employee> lstemp = employeeService.findAll();
        model.addAttribute("lstemp", lstemp);
        return "employees/ViewEmp";
    }
    @RequestMapping(value = "/employee/edit/{id}", method= RequestMethod.GET)
    public String edit(@PathVariable int id, Model model) {
        Employee employee = employeeService.getCusByID(id);
        model.addAttribute("employee", employee);
        return "employees/EditEmp";
    }
    @RequestMapping(value = "/employee/edit/{id}", method= RequestMethod.POST)
    public String edit(@PathVariable Integer id, @ModelAttribute("employee") Employee employee) {
        Employee emp = this.employeeService.getCusByID(id);
        emp.setFullname(employee.getFullname());
        emp.setAddress(employee.getAddress());
        emp.setEmail(employee.getEmail());
        emp.setIdNumber(employee.getIdNumber());
        emp.setPhoneNumber(employee.getPhoneNumber());
        emp.getAccount().setUserName(employee.getAccount().getUserName());
        employeeService.createOrUpdate(emp);
        return "employees/EditEmp";
    }
//    @RequestMapping(value = "/employees/create",method = RequestMethod.GET)
//    public String addEmp(Model model)
//    {
//        return "employees/AddEmp";
//    }

    //    @RequestMapping(value = "/employee", method = RequestMethod.POST)
//    public String create(@Valid Employee employee, BindingResult result, RedirectAttributes redirect) {
//        employeeService.createOrUpdate(employee);
//        redirect.addFlashAttribute("Done.", "Saved employee success!");
//        return "employees/AddEmp";
//    }
//
//    @RequestMapping(value = "/employees/create", method = RequestMethod.GET)
//    public String createemp(Model model) {
//        Employee employee=new Employee();
//        model.addAttribute("employee",employee);
//        return "employees/AddEmp";
//    }
    @RequestMapping(value = "/employees/create", method = RequestMethod.GET)
    public String create(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employees/AddEmp";
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public String create(@Valid Employee employee, BindingResult result, RedirectAttributes redirect) {
        Account acc = new Account();
        acc.setUserName(employee.getAccount().getUserName());
        acc.setPassword(employee.getAccount().getPassword());
        accountService.createOrUpdate(acc);
        employee.setAccount(acc);
        acc.setEmployee(employee);
        employeeService.createOrUpdate(employee);
        redirect.addFlashAttribute("Done.", "Saved customer success!");
        return "employees/AddEmp";
    }
//    @RequestMapping(value = "login", method = RequestMethod.POST)
//    public String loginAdmin(@Valid LoginForm loginForm, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            notifyService.addErrorMessage("Please fill the form correctly!");
//            return "login";
//        }
//
//        employees admin = this.employeeService.findByUsernamePassword(loginForm.getUsername(), loginForm.getPassword());
//
//        if (admin.getEmployee_ID() == 0) {
//            notifyService.addErrorMessage("Username or password is incorrect!");
//            return "login";
//        }
//
//        httpSession.setAttribute("Account", admin);
//        notifyService.addInfoMessage("Login successful");
//        return "redirect:/";
//    }
}
