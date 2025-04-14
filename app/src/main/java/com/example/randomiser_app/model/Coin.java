package com.example.randomiser_app.model;

public class Coin {

    int coinFront;

    int coinBack;
    String coinName;
    double coinSkinPrice;

    public Coin(int coinFront, int coinBack, String coinName, double coinSkinPrice) {
        this.coinFront = coinFront;
        this.coinBack = coinBack;
        this.coinName = coinName;
        this.coinSkinPrice = coinSkinPrice;
    }

    public int getCoinFront() {
        return coinFront;
    }

    public int getCoinBack() {
        return coinBack;
    }

    public String getCoinName() {
        return coinName;
    }

    public double getCoinSkinPrice() {
        return coinSkinPrice;
    }
}
