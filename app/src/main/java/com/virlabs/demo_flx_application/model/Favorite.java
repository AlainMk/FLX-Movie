package com.virlabs.demo_flx_application.model;
import com.google.firebase.firestore.ServerTimestamp;
import com.virlabs.demo_flx_application.entity.Poster;

import java.util.Date;

public class Favorite {
    private String id;
    private String user;
    private Poster movie;
    private Date createdAt;

    public Favorite() {
    }

    public Favorite(String id, String user, Poster movie) {
        this.id = id;
        this.user = user;
        this.movie = movie;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Poster getMovie() {
        return movie;
    }

    public void setMovie(Poster movie) {
        this.movie = movie;
    }

    @ServerTimestamp
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}