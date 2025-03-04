package com.example.randomiser_app.coinflipper;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.example.randomiser_app.R;

public class CoinFlipperClickHandler {

    private Context context;

    public CoinFlipperClickHandler(Context context) {
        this.context = context;
    }

    private void onFlipCoinButtonClicked () {

        CoinFlipperActivity coinFlipperActivity = (CoinFlipperActivity) context;
        ImageView coinImage = coinFlipperActivity.findViewById(R.id.coinimage);
        coinImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                coinImage.animate()
                        .setDuration(1000)
                        .rotationXBy(360f)
                        .start();

            }
        });
    }
}
