package com.res.models;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int post_ID;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)    //
    private PostType postType;

    @Column(nullable = true)
    private Date postTime = new Date();

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    @NumberFormat(pattern = "#,###,###,###.##")
    private double area;

    @Column(nullable = true)
    private String project;

    @Lob @Column(nullable = false)
    private String description;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)    //
    private RealEstaleType realEstaleType;

    @OneToOne(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private PostDetails  details;

    @ManyToOne(optional = false, fetch = FetchType.LAZY) //
    private Customer author;

    @OneToMany(mappedBy = "post")   //
    private Set<PostImages> postImages = new HashSet<>();

    @OneToMany(mappedBy = "post")   //
    private Set<ReportedPost> reportedPosts = new HashSet<>();

    @ManyToOne(optional = false, fetch = FetchType.LAZY) //
    private PostStatus status;
}
