package com.example.randomiser_app.model;

public class Game {

    String name;
    int image;

    public Game(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }
}
