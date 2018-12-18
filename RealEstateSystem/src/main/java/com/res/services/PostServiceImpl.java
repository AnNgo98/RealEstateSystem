package com.res.services;

import com.res.repositories.PostRepository;
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

    @Override
    public int postsToday() {
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        int total = Math.toIntExact(this.postRepo.findAll().stream().filter(p -> Objects.equals(formatDate.format(p.getPostTime()), formatDate.format(new Date()))).count());
        return 0;
    }
//
//
//    @Override
//    public List<Post> findAll() {
//        return this.postRepo.findAll();
//    }
//
//    @Override
//    public List<Post> findLatest5() {
//        List<Post> lstPost = this.postRepo.findLatest5Posts(new PageRequest(0, 5));
//        return lstPost;
//    }
//
//    @Override
//    public Post findById(int id) {
//        return this.postRepo.findOne(id);
//    }
//
//    @Override
//    public boolean create(Post post) {
//        try {
//            this.postRepo.save(post);
//            return true;
//        } catch (Exception e){
//            return false;
//        }
//
//    }
//
//    @Override
//    public Post edit(Post post) {
//        return this.postRepo.save(post);
//    }
//
//    @Override
//    public void deleteById(int id) {
//        this.postRepo.delete(id);
//    }
}
