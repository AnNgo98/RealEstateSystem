package com.res.services;


import com.res.models.Post;

import java.util.List;

public interface PostService {
    int postsToday();

    List<Post> findAll();

    Post findById(int id);

    boolean createOrEdit(Post post);

    public boolean approve(int post_id);

    public boolean block(int post_id);
}
