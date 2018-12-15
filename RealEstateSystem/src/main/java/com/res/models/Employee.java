package com.res.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employee_ID;

    @Column(nullable = false, length = 100)
    private String fullname;

    @Column(nullable = true)
    private int idNumber;

    @Column(nullable = true)
    private int phoneNumber;

    @Column(nullable = false, length = 50)
    private String email;

    @Lob @Column(nullable = false, length = 200)
    private String address;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)    //
    private Employee manager;

    @Column(nullable = false, length = 50)
    private String username;

    @Column(nullable = false, length = 100)
    private String password;

    @OneToMany(mappedBy = "manager")    //
    private Set<Employee> employees = new HashSet<>();

    @OneToMany(mappedBy = "censor") //
    private Set<ReportedPost> censorshipPosts = new HashSet<>();
}
