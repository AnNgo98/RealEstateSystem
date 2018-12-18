package com.res.controllers;

import com.res.models.Post;
import com.res.services.NotificationService;
import com.res.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private NotificationService notifyService;

    public String approve(int post_id) {
        try {
            if (this.postService.approve(post_id)) {
                notifyService.addInfoMessage("Approve post successful");
                return "redirect:/posts";
            }
        } catch (Exception e) { }

        notifyService.addErrorMessage("Approve post failed. Please try again!");
        return "posts";
    }

    public String block(int post_id) {
        try {
            if (this.postService.block(post_id)) {
                notifyService.addInfoMessage("Block post successful");
                return "redirect:/posts";
            }
        } catch (Exception e) { }

        notifyService.addErrorMessage("Block post failed. Please try again!");
        return "posts";
    }
}
