package com.example.randomiser_app.model;

import java.util.List;

public class Deck {

    String deckName;
    List<Card> cardList;

    int cardBack;

    double deckPrice;

    public String getDeckName() {
        return deckName;
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public int getCardBack() {
        return cardBack;
    }

    public double getDeckPrice() {
        return deckPrice;
    }

    public Deck(String deckName, List<Card> cardList, int cardBack, double deckPrice) {
        this.deckName = deckName;
        this.cardList = cardList;
        this.cardBack = cardBack;
        this.deckPrice = deckPrice;


    }
}
