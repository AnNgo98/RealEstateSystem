package com.res.models;

import javax.persistence.*;

@Entity
@Table(name = "post_images")
public class PostImages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int image_ID;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)    //
    private Post post;

    @Column(nullable = false, length = 100)
    private String url;
}
