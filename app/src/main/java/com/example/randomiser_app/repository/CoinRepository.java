package com.example.randomiser_app.repository;

import com.example.randomiser_app.R;
import com.example.randomiser_app.model.Coin;

import java.util.ArrayList;
import java.util.List;

public class CoinRepository {

    public List<Coin> getAllCoinSkins() {

        Coin exampleCoin = new Coin(R.drawable.coinlogo, R.drawable.coinrearview, "Sample Coin", 0.30);

        List<Coin> coinSkinList = new ArrayList<>();
        coinSkinList.add(exampleCoin);

        return coinSkinList;
    }
}
