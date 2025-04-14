package com.example.randomiser_app.ui.deckshuffler;

import static android.view.View.TEXT_ALIGNMENT_TEXT_START;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.randomiser_app.R;
import com.example.randomiser_app.databinding.ActivityDeckShufflerBinding;

public class DeckShufflerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityDeckShufflerBinding binding = ActivityDeckShufflerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setUpToolbar();
    }

    private void setUpToolbar(){

        Toolbar toolbar =  findViewById(R.id.customtoolbar);
        Log.i("DeckShufflerActivity", "toolbar: " + toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setToolbarText();
    }

    private void setToolbarText(){
        TextView toolbarTitle = findViewById(R.id.maintoolbartitle);
        toolbarTitle.setText(R.string.deck_shuffler_toolbar_title);
        toolbarTitle.setTextAlignment(TEXT_ALIGNMENT_TEXT_START);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}