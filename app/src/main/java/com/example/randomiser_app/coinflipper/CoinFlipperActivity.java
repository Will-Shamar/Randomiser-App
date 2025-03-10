package com.example.randomiser_app.coinflipper;

import static android.view.View.TEXT_ALIGNMENT_TEXT_START;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.randomiser_app.R;
import com.example.randomiser_app.databinding.ActivityCoinFlipperBinding;

public class CoinFlipperActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Need to set bindings manually and get the view from that in order to databind
        ActivityCoinFlipperBinding binding = ActivityCoinFlipperBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setUpToolbar();
    }

    private void setUpToolbar(){

        Toolbar toolbar =  findViewById(R.id.customtoolbar);
        Log.i("CoinFlipperActivity", "toolbar: " + toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setToolbarText();
    }

    private void setToolbarText(){
        TextView toolbarTitle = findViewById(R.id.maintoolbartitle);
        toolbarTitle.setText(R.string.coin_flippers_toolbar_title);
        toolbarTitle.setTextAlignment(TEXT_ALIGNMENT_TEXT_START);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle back button arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to previous activity (if there is any)
        }
        return super.onOptionsItemSelected(item);
    }


}