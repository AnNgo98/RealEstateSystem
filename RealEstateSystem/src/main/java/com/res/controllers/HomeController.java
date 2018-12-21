package com.res.controllers;

import com.res.services.PostService;
import com.res.utils.WebUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
    private PostService postService;

    @RequestMapping("/Customer/IndexCustomer")
    public String index(Model model) {
        int postsToday = postService.postsToday();
        model.addAttribute("postsToday", postsToday);
//
//        List<Post> latest3Posts = latest5Posts.stream()
//                .limit(3).collect(Collectors.toList());
//        model.addAttribute("latest3posts", latest3Posts);
        return "Customer/IndexCustomer";
    }

    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "logoutSuccessfulPage";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();

            String userInfo = WebUtils.toString(loginedUser);

            model.addAttribute("userInfo", userInfo);

            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);

        }

        return "error/403Page";
    }
}
