package com.res.controllers;

import com.res.forms.PostForm;
import com.res.models.Post;
import com.res.models.ReportedPost;
import com.res.services.NotificationService;
import com.res.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private NotificationService notifyService;

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public String index(Model model)
    {
        List<Post> lstPost = this.postService.findAll();

        model.addAttribute("lstPost", lstPost);

        return "posts/index";
    }

    @RequestMapping(value = "/posts/pending", method = RequestMethod.GET)
    public String pending(Model model)
    {
        List<Post> lstPending = this.postService.pendingPosts();

        model.addAttribute("lstPending", lstPending);

        return "posts/PendingPost";
    }

    @RequestMapping(value = "/posts/reported", method = RequestMethod.GET)
    public String reported(Model model)
    {
        List<ReportedPost> lstReported = this.postService.reportedPosts();

        model.addAttribute("lstReported", lstReported);

        return "posts/ReportPost";
    }

    @RequestMapping(value = "/posts/create", method = RequestMethod.GET)
    public String create(PostForm postForm)
    {
        return "posts/AddPost";
    }


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
