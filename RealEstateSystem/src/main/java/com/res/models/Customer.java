package com.res.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customer_ID;

    @Column(nullable = false, length = 100)
    private String fullname;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 200)
    private String address;

    @Column(nullable = false, length = 50)
    private String username;

    @Column(nullable = false, length = 100)
    private String passwordHash;

    @OneToMany(mappedBy = "author") //
    private Set<Post> posts = new HashSet<>();

    @OneToMany(mappedBy = "reporter")   //
    private Set<ReportedPost> reportedPosts = new HashSet<>();
}