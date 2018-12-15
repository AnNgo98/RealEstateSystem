package com.res.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "realestate_type")
public class RealEstaleType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int realestate_ID;

    @Column(nullable = false, length = 10)
    private String realestate_Title;

    @OneToMany(mappedBy = "realEstaleType") //
    private Set<Post> posts = new HashSet<>();
}
