package com.example.randomiser_app.ui.mainactivity;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.randomiser_app.model.Game;
import com.example.randomiser_app.repository.GameRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private GameRepository gameRepository;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.gameRepository = new GameRepository();
    }

    public List<Game> fetchAllGames() {
        return gameRepository.getAllGames();
    }
}
