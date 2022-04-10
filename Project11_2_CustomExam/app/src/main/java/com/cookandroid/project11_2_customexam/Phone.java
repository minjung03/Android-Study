package com.cookandroid.project11_2_customexam;

import android.graphics.drawable.Drawable;

public class Phone {

    Drawable image;
    String PName;

    public Phone(Drawable image, String PName) {
        this.image = image;
        this.PName = PName;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public void setPName(String PName) {
        this.PName = PName;
    }

    public Drawable getImage() {
        return image;
    }

    public String getPName() {
        return PName;
    }

}
