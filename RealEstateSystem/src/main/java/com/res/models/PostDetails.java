package com.res.models;

import javax.persistence.*;

@Entity
@Table(name = "post_details")
public class PostDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int details_ID;

    @Column(nullable = false)
    private int bedroom;

    @Column(nullable = false)
    private int bathroom;

    @Column(nullable = false)
    private int floor;

    @Column(nullable = false)
    private boolean alley;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)    //
    private Direction direction;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_ID")
    private Post post;

    public int getDetails_ID() {
        return details_ID;
    }

    public void setDetails_ID(int details_ID) {
        this.details_ID = details_ID;
    }

    public int getBedroom() {
        return bedroom;
    }

    public void setBedroom(int bedroom) {
        this.bedroom = bedroom;
    }

    public int getBathroom() {
        return bathroom;
    }

    public void setBathroom(int bathroom) {
        this.bathroom = bathroom;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public boolean isAlley() {
        return alley;
    }

    public void setAlley(boolean alley) {
        this.alley = alley;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public PostDetails() {
    }

    public PostDetails(int bedroom, int bathroom, int floor, boolean alley, Direction direction) {
        this.bedroom = bedroom;
        this.bathroom = bathroom;
        this.floor = floor;
        this.alley = alley;
        this.direction = direction;
    }
}
