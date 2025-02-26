package com.example.randomiser_app.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.randomiser_app.R;
import com.example.randomiser_app.databinding.GamesButtonLayoutBinding;
import com.example.randomiser_app.model.Game;
import com.example.randomiser_app.ui.mainactivity.RecyclerViewInterface;

import java.util.List;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.GamesViewHolder>{

    private Context context;

    private List<Game> gameList;

    private RecyclerViewInterface recyclerViewInterface;

    public GameAdapter(Context context, List<Game> gameList, RecyclerViewInterface recyclerViewInterface){
        this.context = context;
        this.gameList = gameList;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public GamesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        GamesButtonLayoutBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.games_button_layout,
                parent,
                false
        );
        return new GamesViewHolder(binding, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull GamesViewHolder holder, int position) {
        Game game = gameList.get(position);
        int theme = game.getTheme();
        Typeface typeface = ResourcesCompat.getFont(context, game.getFontStyle());
        holder.gamesButtonLayoutBinding.setGame(game);

        holder.gamesButtonLayoutBinding.gameButton.setBackgroundResource(theme);
        holder.gamesButtonLayoutBinding.gameName.setTypeface(typeface);

        holder.itemView.setOnClickListener(view -> {
            if (recyclerViewInterface != null) {
                recyclerViewInterface.onItemClick(position);

            }
        });
    }

    @Override
    public int getItemCount() {
        return gameList.size();
    }

    public static class GamesViewHolder extends RecyclerView.ViewHolder {

GamesButtonLayoutBinding gamesButtonLayoutBinding;

    public GamesViewHolder(GamesButtonLayoutBinding gamesButtonLayoutBinding, RecyclerViewInterface recyclerViewInterface) {
        super(gamesButtonLayoutBinding.getRoot());
        this.gamesButtonLayoutBinding = gamesButtonLayoutBinding;
    }
}
}
