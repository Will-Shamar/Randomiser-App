package com.example.randomiser_app.coinflipper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.randomiser_app.R;
import com.example.randomiser_app.databinding.CoinSkinItemLayoutBinding;
import com.example.randomiser_app.model.Coin;
import com.example.randomiser_app.ui.mainactivity.RecyclerViewInterface;

import java.util.List;

public class CoinFlipperAdapter extends RecyclerView.Adapter<CoinFlipperAdapter.CoinSkinViewHolder> {

    private Context context;
    private List<Coin> coinSkinList;
    private RecyclerViewInterface recyclerViewInterface;
    public CoinFlipperAdapter(Context context, List<Coin> coinSkinList, RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.coinSkinList = coinSkinList;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public CoinSkinViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CoinSkinItemLayoutBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.coin_skin_item_layout,
                parent,
                false
        );
        return new CoinSkinViewHolder(binding, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull CoinSkinViewHolder holder, int position) {
        Coin coin = coinSkinList.get(position);
//        holder.coinSkinItemLayoutBinding.setCoinSkin(coin);
        holder.coinSkinItemLayoutBinding.coinSkinImage.setImageResource(coin.getCoinFront());
        holder.coinSkinItemLayoutBinding.coinSkinName.setText(coin.getCoinName());
        holder.itemView.setOnClickListener(view -> {
            if (recyclerViewInterface != null) {
                recyclerViewInterface.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return coinSkinList.size();
    }

    public static class CoinSkinViewHolder extends RecyclerView.ViewHolder {

        CoinSkinItemLayoutBinding coinSkinItemLayoutBinding;

        public CoinSkinViewHolder(CoinSkinItemLayoutBinding coinSkinItemLayoutBinding, RecyclerViewInterface recyclerViewInterface) {
            super(coinSkinItemLayoutBinding.getRoot());
            this.coinSkinItemLayoutBinding = coinSkinItemLayoutBinding;
        }
    }
}
