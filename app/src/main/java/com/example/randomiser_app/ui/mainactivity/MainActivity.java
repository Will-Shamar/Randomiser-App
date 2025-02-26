package com.example.randomiser_app.ui.mainactivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.randomiser_app.R;
import com.example.randomiser_app.coinflipper.CoinFlipperActivity;
import com.example.randomiser_app.databinding.ActivityMainBinding;
import com.example.randomiser_app.model.Game;
import com.example.randomiser_app.ui.adapter.GameAdapter;

import java.util.List;


public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {

    RecyclerView recyclerView;
    List<Game> gameList;

    GameAdapter adapter;

    ActivityMainBinding binding;

    MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        gameList = mainActivityViewModel.fetchAllGames();
        recyclerView = binding.GamesList;
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new GameAdapter(this, gameList, this);
        recyclerView.setAdapter(adapter);


    }

    @Override
    public void onItemClick(int position) {

        Intent intent = new Intent();
        switch (gameList.get(position).getName()) {
//
//            case "Dice Roll":
//                intent = new Intent(MainActivity.this, DiceRollerActivity.class);
//                break;
            case "Coin Flip":
                intent = new Intent(MainActivity.this, CoinFlipperActivity.class);
                break;
//            case "Pick a Card":
//                intent = new Intent(MainActivity.this, CardPickerActivity.class);
//                break;
//            case "Draw Straws":
//                intent = new Intent(MainActivity.this, DrawStrawsActivity.class);
//                break;
//
            default:
                Toast.makeText(this, "Unable to launch game", Toast.LENGTH_SHORT)
                        .show();

        }

        startActivity(intent);
//
//
//        // TODO: 20/02/2025 Add logic for launching separate game activities
    }
}