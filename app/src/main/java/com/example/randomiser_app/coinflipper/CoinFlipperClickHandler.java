package com.example.randomiser_app.coinflipper;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.randomiser_app.R;

import java.util.concurrent.atomic.AtomicInteger;

public class CoinFlipperClickHandler extends Handler {

    private Context context;
    private int curSide = R.drawable.coinlogo;
    public CoinFlipperClickHandler(Context context) {
        this.context = context;
    }
    private static int curValue;

    public void onFlipCoinButtonClicked(View view) {

        CoinFlipperActivity coinFlipperActivity = (CoinFlipperActivity) context;
        TextView numberOfFlips = coinFlipperActivity.findViewById(R.id.numberOfFlips);
        long waitDuration = animateCoin(flipRandomizer());
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                curValue++;
                numberOfFlips.setText(String.valueOf(curValue));
                setEnabledButtons(true);
                TextView historyList = coinFlipperActivity.findViewById(R.id.fliphistorylist);
                if (curSide == R.drawable.coinlogo) {
                    historyList.append("H ");
//                    autoScrollTextView();
                } else {
                    historyList.append("T ");
//                    autoScrollTextView();
                }
            }
        }, waitDuration + 500);
        autoScrollTextView();
    }

    public long animateCoin(boolean stayTheSame) {
        FlipAnimation animation;
        CoinFlipperActivity coinFlipperActivity = (CoinFlipperActivity) context;
        ImageView coinImage = coinFlipperActivity.findViewById(R.id.coinimage);


        if (curSide == R.drawable.coinlogo) {
            animation = new FlipAnimation(coinImage, R.drawable.coinlogo, R.drawable.coinrearview, 0, 180, 0, 0, 0, 0);
        } else {
            animation = new FlipAnimation(coinImage, R.drawable.coinrearview, R.drawable.coinlogo, 0, 180, 0, 0, 0, 0);
        }
        if (stayTheSame) {
            animation.setRepeatCount(5);
        } else {
            animation.setRepeatCount(6);
            if (curSide == R.drawable.coinlogo) {
                curSide = R.drawable.coinrearview;
            } else {
                curSide = R.drawable.coinlogo;
            }
        }
        animation.setDuration(110);
        animation.setInterpolator(new LinearInterpolator());

        coinImage.startAnimation(animation);
        setEnabledButtons(false);
        return animation.getDuration() * (animation.getRepeatCount() + 1);
    }

    private void setEnabledButtons(boolean isEnabled) {
        CoinFlipperActivity coinFlipperActivity = (CoinFlipperActivity) context;
        coinFlipperActivity.findViewById(R.id.coinflipbutton).setEnabled(isEnabled);
    }

    private boolean flipRandomizer() {
        double randomNumber = Math.round(Math.random());
        if (randomNumber == 1.0) {
            return true;
        }
        return false;
    }

    private void autoScrollTextView() {
        CoinFlipperActivity coinFlipperActivity = (CoinFlipperActivity) context;
        TextView historyList = coinFlipperActivity.findViewById(R.id.fliphistorylist);
        historyList.post(() -> {
            int content = historyList.getLayout().getWidth();
            int visible = historyList.getWidth();
            if(content > visible){
                historyList.scrollTo(curValue, 0);
            }
            else {
                historyList.scrollTo(0, 0);
            }
        });
    }
}
