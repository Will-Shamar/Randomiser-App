package com.example.randomiser_app;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.randomiser_app.databinding.ActivityMainBinding;
import com.example.randomiser_app.model.Game;
import com.example.randomiser_app.ui.adapter.GameAdapter;
import com.example.randomiser_app.ui.mainactivity.MainActivityViewModel;
import com.example.randomiser_app.ui.mainactivity.RecyclerViewInterface;
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


        // TODO: 20/02/2025 Add logic for launching separate game activities 
    }
}