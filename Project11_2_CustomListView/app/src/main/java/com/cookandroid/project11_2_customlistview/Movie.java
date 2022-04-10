package com.cookandroid.project11_2_customlistview;

import android.graphics.drawable.Drawable;

import java.sql.Driver;

public class Movie {

    Drawable image;
    String title;
    String genre;

    public Movie (Drawable image, String title, String genre){
        this.image = image;
        this.title = title;
        this.genre = genre;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Drawable getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }
}
