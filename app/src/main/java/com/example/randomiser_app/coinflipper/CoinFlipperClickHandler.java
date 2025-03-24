package com.example.randomiser_app.coinflipper;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.example.randomiser_app.R;

public class CoinFlipperClickHandler extends Handler {

    private Context context;
    private int curSide = R.drawable.coinlogo;
    public CoinFlipperClickHandler(Context context) {
        this.context = context;
    }

    public void onFlipCoinButtonClicked (View view) {

     animateCoin(false);
    }

    public long animateCoin(boolean stayTheSame){
        FlipAnimation animation;
        CoinFlipperActivity coinFlipperActivity = (CoinFlipperActivity) context;
        ImageView coinImage = coinFlipperActivity.findViewById(R.id.coinimage);


        if(curSide == R.drawable.coinlogo){
            animation = new FlipAnimation(coinImage,R.drawable.coinlogo, R.drawable.coinrearview,0,180,0,0,0,0);
        }
        else{
            animation = new FlipAnimation(coinImage,R.drawable.coinrearview, R.drawable.coinlogo,0,180,0,0,0,0);
        }
        if(stayTheSame){
            animation.setRepeatCount(5);
        }
        else{
            animation.setRepeatCount(6);
        }
        animation.setDuration(110);
        animation.setInterpolator(new LinearInterpolator());

        coinImage.startAnimation(animation);
        return animation.getDuration() * (animation.getRepeatCount() + 1);
    }



}
