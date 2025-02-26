package com.example.randomiser_app.model;

import android.graphics.Typeface;
import android.graphics.fonts.FontStyle;

import com.example.randomiser_app.R;

public class Game {

    String name;
    int image;
    int theme;

    int fontStyle;

    public Game(String name, int image, int theme, int fontStyle) {
        this.name = name;
        this.image = image;
        this.theme = theme;
        this.fontStyle = fontStyle;

    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public int getTheme() {
        return theme;
    }

    public int getFontStyle() {
        return fontStyle;
    }

    }




