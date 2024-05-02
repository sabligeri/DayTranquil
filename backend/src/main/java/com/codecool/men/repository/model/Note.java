package com.codecool.men.repository.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
public class Note {

//    String title,
//    String text,
//    Date created,
//    int userId

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String text;
    private LocalDate date;
    @ManyToOne(optional = false)
    @JsonManagedReference
    private User user;
    private boolean isFavorite;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public LocalDate getDate() {
        return date;
    }

    public User getUser() {
        return user;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
