package com.example.randomiser_app.coinflipper;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.randomiser_app.model.Coin;
import com.example.randomiser_app.repository.CoinRepository;

import java.util.List;

public class CoinFlipperViewModel extends AndroidViewModel {

    private CoinRepository coinRepository;

    public CoinFlipperViewModel(@NonNull Application application) {
        super(application);
        this.coinRepository = new CoinRepository();
    }

    public List<Coin> fetchAllCoins(){
        return coinRepository.getAllCoinSkins();
    }
}
