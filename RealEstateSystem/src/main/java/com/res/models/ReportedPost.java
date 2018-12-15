package com.res.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reported_post")
public class ReportedPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int report_ID;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)    //
    private Post post;

    @Column(nullable = false, length = 200)
    private String reason;

    @Column(nullable = false, length = 200)
    private Date reportedTime = new Date();

    @ManyToOne(optional = false, fetch = FetchType.LAZY)    //
    private Customer reporter;

    private boolean status;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)    //
    private Employee censor;
}
