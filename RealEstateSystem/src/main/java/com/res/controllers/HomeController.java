package com.res.controllers;

import com.res.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    @Autowired
    private PostService postService;

    @RequestMapping("/")
    public String index(Model model) {
        int postsToday = postService.postsToday();
        model.addAttribute("postsToday", postsToday);
//
//        List<Post> latest3Posts = latest5Posts.stream()
//                .limit(3).collect(Collectors.toList());
//        model.addAttribute("latest3posts", latest3Posts);
        return "index";
    }
}
