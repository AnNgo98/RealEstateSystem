package com.res.services;

import com.res.models.Post;
import com.res.repositories.PostRepository;
import com.res.repositories.PostStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepo;
    @Autowired
    private PostStatusRepository postStatusRepo;

    @Override
    public int postsToday() {
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        int total = Math.toIntExact(this.postRepo.findAll().stream().filter(p -> Objects.equals(formatDate.format(p.getPostTime()), formatDate.format(new Date()))).count());
        return 0;
    }

    @Override
    public List<Post> findAll() {
        return this.postRepo.findAll();
    }

    @Override
    public Post findById(int id) {
        return this.postRepo.findOne(id);
    }

    @Override
    public boolean createOrEdit(Post post) {
        try {
            this.postRepo.save(post);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean approve(int post_id) {
        try {
            Post post = this.postRepo.findOne(post_id);
            post.setStatus(this.postStatusRepo.findOne(2));
            this.postRepo.save(post);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean block(int post_id) {
        try {
            Post post = this.postRepo.findOne(post_id);
            post.setStatus(this.postStatusRepo.findOne(3));
            this.postRepo.save(post);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
