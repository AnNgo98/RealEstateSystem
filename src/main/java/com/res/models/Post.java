package com.res.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 300)
    @NotNull
    @Size(min = 10, max = 100, message = "Title size should be in the range [10...100]")
    private String title;

    @Lob @Column(nullable = false)
    @NotNull
    @Size(min = 10, max = 3000, message = "Username size should be in the range [10...3000]")
    private String body;

//    @ManyToOne(optional = false, fetch = FetchType.LAZY)
//    @NotNull
//    private User author;

    @Column(nullable = false)
    private Date date = new Date();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

//    public User getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(User author) {
//        this.author = author;
//    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Post() {
    }

//    public Post(int id, String title, String body, User author) {
//        this.id = id;
//        this.title = title;
//        this.body = body;
//        this.author = author;
//    }
//
//    @Override
//    public String toString() {
//        return "id = " + id + ", tittle: " + title + ", body: " + body + ", author: " + author.getFullName();
//    }
}
