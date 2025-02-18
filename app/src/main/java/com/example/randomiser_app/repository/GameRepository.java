package com.example.randomiser_app.repository;

import com.example.randomiser_app.R;
import com.example.randomiser_app.model.Game;

import java.util.ArrayList;
import java.util.List;

public class GameRepository {

    public List<Game> getAllGames(){

        Game diceRoll = new Game("Dice Roll", R.drawable.ic_launcher_foreground );
        Game coinFlip = new Game("Coin Flip", R.drawable.ic_launcher_foreground );
        Game cardPick = new Game("Pick a Card", R.drawable.ic_launcher_foreground  );
        Game drawStraws = new Game("Draw Straws", R.drawable.ic_launcher_foreground );

        // TODO: 18/02/2025 Add images to drawable folder & reference above 

        List<Game> gamesList = new ArrayList<>();
        gamesList.add(diceRoll);
        gamesList.add(coinFlip);
        gamesList.add(cardPick);
        gamesList.add(drawStraws);

        return gamesList;

    }
}
