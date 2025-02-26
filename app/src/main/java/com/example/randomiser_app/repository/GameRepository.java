package com.example.randomiser_app.repository;

import android.graphics.fonts.Font;
import android.graphics.fonts.FontStyle;

import com.example.randomiser_app.R;
import com.example.randomiser_app.model.Game;

import java.util.ArrayList;
import java.util.List;

public class GameRepository {

    public List<Game> getAllGames(){

        Game diceRoll = new Game("Dice Roll", R.drawable.ic_launcher_foreground, R.drawable.gradient_colour_2, R.font.caveat_variablefont_wght);
        Game coinFlip = new Game("Coin Flip", R.drawable.ic_launcher_foreground, R.drawable.gradient_colour_4, R.font.dancingscript_variablefont_wght);
        Game cardPick = new Game("Pick a Card", R.drawable.ic_launcher_foreground, R.drawable.gradient_colour_1, R.font.indieflower_regular);
        Game drawStraws = new Game("Draw Straws", R.drawable.ic_launcher_foreground, R.drawable.gradient_colour_3, R.font.moondance_regular);

        // TODO: 18/02/2025 Add images to drawable folder & reference above 

        List<Game> gamesList = new ArrayList<>();
        gamesList.add(diceRoll);
        gamesList.add(coinFlip);
        gamesList.add(cardPick);
        gamesList.add(drawStraws);

        return gamesList;

    }
}
