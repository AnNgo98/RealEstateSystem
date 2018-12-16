package com.res.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "post_type")
public class PostType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int type_ID;

    @Column(nullable = false, length = 10)
    private String type_Tittle;

    @OneToMany(mappedBy = "postType")   //
    private Set<Post> posts = new HashSet<>();
}
