package com.example.test;

import android.media.MediaPlayer;

public class Letter {
    private int position;
    private String name;
     private String message;
     private MediaPlayer latterSound;


    public Letter(int position, String name, String message, MediaPlayer latterSound) {
        this.position = position;
        this.name = name;
        this.message = message;
        this.latterSound = latterSound;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MediaPlayer getLatterSound() {
        return latterSound;
    }

    public void setLatterSound(MediaPlayer latterSound) {
        this.latterSound = latterSound;
    }
}