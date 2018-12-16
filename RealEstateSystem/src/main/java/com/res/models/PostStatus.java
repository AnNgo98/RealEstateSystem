package com.res.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "block_status_post")
public class PostStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int status_ID;

    @Column(nullable = false, length = 100)
    private String status_Title;

    @OneToMany(mappedBy = "status") //
    private Set<Post> posts = new HashSet<>();
}
