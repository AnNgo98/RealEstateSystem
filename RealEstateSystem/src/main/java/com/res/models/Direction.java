package com.res.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "direction")
public class Direction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int direction_ID;

    @Column(nullable = false, length = 30)
    private String direction_Title;

    @OneToMany(mappedBy = "direction")  //
    private Set<PostDetails> postsDetail = new HashSet<>();
}
