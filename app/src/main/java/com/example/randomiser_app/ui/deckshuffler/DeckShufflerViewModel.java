package com.example.randomiser_app.ui.deckshuffler;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.randomiser_app.model.Deck;
import com.example.randomiser_app.repository.CardDeckRepository;

import java.util.List;

public class DeckShufflerViewModel extends AndroidViewModel {

    private CardDeckRepository cardDeckRepository;

    public DeckShufflerViewModel(@NonNull Application application) {
        super(application);
        this.cardDeckRepository = new CardDeckRepository();
    }

    public List<Deck> fetchAllDecks() {
        return cardDeckRepository.getAllDeckSkins();
    }
}
