package com.example.randomiser_app.ui.deckshuffler;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import androidx.lifecycle.ViewModelProvider;

import com.example.randomiser_app.R;
import com.example.randomiser_app.model.Card;
import com.example.randomiser_app.model.Deck;
import com.example.randomiser_app.repository.CardDeckRepository;

public class DeckShufflerClickHandler extends Handler {

    private Deck deck;
    private CardDrawAnimation cardDrawAnimation;
    private ImageView hiddenCard;
    private ImageView revealedCard;

    private Context context;

    public DeckShufflerClickHandler(Context context) {
        this.context = context;
    }
    public void onDrawCardButtonClick(View view) {
        DeckShufflerActivity deckShufflerActivity = (DeckShufflerActivity)context;
        cardDrawAnimation = new CardDrawAnimation();
        hiddenCard = deckShufflerActivity.findViewById(R.id.deckImage);
        revealedCard = deckShufflerActivity.findViewById(R.id.revealedCard);
        DeckShufflerViewModel deckShufflerViewModel = new ViewModelProvider(deckShufflerActivity).get(DeckShufflerViewModel.class);
        deck = deckShufflerViewModel.fetchAllDecks().get(0);
        if (!deck.getCardList().isEmpty()) {
            Card drawnCard = deck.getCardList().remove(0);
            cardDrawAnimation.revealCard(revealedCard, hiddenCard, drawnCard.getCardFront());
        }
    }
    public void updateDeck(Deck newDeck) {
        this.deck = newDeck;
    }
}
