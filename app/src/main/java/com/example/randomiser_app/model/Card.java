package com.example.randomiser_app.model;

public class Card {

    public Card(String cardName, int cardFront) {
        this.cardName = cardName;
        this.cardFront = cardFront;
    }
    String cardName;
    int cardFront;

    public String getCardName() {
        return cardName;
    }
    public int getCardFront() {
        return cardFront;
    }
}
