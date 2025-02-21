package com.example.randomiser_app.coinflipper;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import com.example.randomiser_app.R;
import com.example.randomiser_app.databinding.ActivityCoinFlipperBinding;
import com.example.randomiser_app.databinding.ActivityMainBinding;

public class CoinFlipperActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_coin_flipper);
//        Toolbar myToolbar = findViewById(R.id.my_toolbar);
//        setSupportActionBar(myToolbar);
//        getSupportActionBar().setTitle("Coin Flipper");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
        ActivityCoinFlipperBinding binding = ActivityCoinFlipperBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Toolbar toolbar =  findViewById(R.id.MAINTOOL);
        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);

        TextView whatIneed = findViewById(R.id.maintoolbartitle);
        whatIneed.setText("COIN FLIPPER");







    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }
        return super.onOptionsItemSelected(item);
    }


}