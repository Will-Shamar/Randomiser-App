package com.example.randomiser_app.repository;

import com.example.randomiser_app.R;
import com.example.randomiser_app.model.Card;
import com.example.randomiser_app.model.Deck;

import java.util.ArrayList;
import java.util.List;

public class CardDeckRepository {

    public List<Deck> getAllDeckSkins(){

        Card testCard = new Card("sampleCard", R.drawable.sample_card_front_view);
        List<Card> practiceList = new ArrayList<>();
        practiceList.add(testCard);

        Deck testDeck = new Deck("testDeck", practiceList, R.drawable.sample_card_rear_view, 0.50);

        List<Deck> listOfDecks = new ArrayList<>();
        listOfDecks.add(testDeck);

        return listOfDecks;
    }
}
