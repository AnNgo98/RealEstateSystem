package com.res.services;


import com.res.models.Post;

import java.util.List;

public interface  PostService {
    List<Post> findAll();
    List<Post> findLatest5();
    Post findById(int id);
    boolean create(Post post);
    Post edit(Post post);
    void deleteById(int id);
}
