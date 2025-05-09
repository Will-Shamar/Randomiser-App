package com.example.randomiser_app.coinflipper;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.randomiser_app.R;
import com.example.randomiser_app.model.Coin;
import com.example.randomiser_app.ui.mainactivity.RecyclerViewInterface;

import java.util.List;

public class CoinFlipperClickHandler extends Handler implements RecyclerViewInterface {

    private Context context;
    private int curSide = R.drawable.coinlogo;
    public CoinFlipperClickHandler(Context context) {
        this.context = context;
    }
    private int curValue;

    public void onFlipCoinButtonClicked(View view) {

        CoinFlipperActivity coinFlipperActivity = (CoinFlipperActivity) context;
        TextView numberOfFlips = coinFlipperActivity.findViewById(R.id.numberOfFlips);
        long waitDuration = animateCoin(flipRandomizer());
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

        setAnimationEndText(animation);
        showTextResult("N");

        return animation.getDuration() * (animation.getRepeatCount() + 1);
    }

    private void setEnabledButtons(boolean isEnabled) {
        CoinFlipperActivity coinFlipperActivity = (CoinFlipperActivity) context;
        coinFlipperActivity.findViewById(R.id.coinflipbutton).setEnabled(isEnabled);
        coinFlipperActivity.findViewById(R.id.coinskinsbutton).setEnabled(isEnabled);
    }

    private boolean flipRandomizer() {
        double randomNumber = Math.round(Math.random());
        return randomNumber == 1.0;
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

    private void setAnimationEndText(Animation animation){
        CoinFlipperActivity coinFlipperActivity = (CoinFlipperActivity) context;

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                setEnabledButtons(false);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                setEnabledButtons(true);

                TextView numberOfFlips = coinFlipperActivity.findViewById(R.id.numberOfFlips);

                TextView historyList = coinFlipperActivity.findViewById(R.id.fliphistorylist);
                HorizontalScrollView scrollView = coinFlipperActivity.findViewById(R.id.horizonalScrollView);
                curValue++;
                numberOfFlips.setText(String.valueOf(curValue));

                if (curSide == R.drawable.coinlogo) {
                    historyList.append("H ");
                    showTextResult("H");
                } else {
                    historyList.append("T ");
                    showTextResult("T");
                }
                scrollView.post(new Runnable() {
                    @Override
                    public void run() {
                        scrollView.fullScroll(HorizontalScrollView.FOCUS_RIGHT);
                    }
                });

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


    }


    public void onSkinsButtonClicked(View view) {

        CoinFlipperActivity coinFlipperActivity = (CoinFlipperActivity) context;
        LayoutInflater inflater = (LayoutInflater) coinFlipperActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.coin_skins_menu, null);

        final PopupWindow popupWindow = new PopupWindow(
                popupView,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                true
        );

        RecyclerView recyclerView = popupView.findViewById(R.id.coinSkinsrecycler);
        CoinFlipperViewModel coinFlipperViewModel = new ViewModelProvider(coinFlipperActivity).get(CoinFlipperViewModel.class);
        List<Coin> coinList = coinFlipperViewModel.fetchAllCoins();

        LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new CoinFlipperAdapter(context, coinList, CoinFlipperClickHandler.this));
        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
        recyclerView.post(() -> {
           int recyclerViewWidth = recyclerView.getWidth();
           int itemWidth = (int) TypedValue.applyDimension(
                   TypedValue.COMPLEX_UNIT_DIP,
                   250,
                   recyclerView.getResources().getDisplayMetrics()
           );
           int offset = (recyclerViewWidth - itemWidth) / 2;

           layoutManager.scrollToPositionWithOffset(0, offset);
        });

        popupWindow.showAtLocation(view, Gravity.CENTER, 0, -280);

        popupView.setOnTouchListener((v, event) -> {
            popupWindow.dismiss();
            return true;
        });
    }


    private void showTextResult(String result){
        CoinFlipperActivity coinFlipperActivity = (CoinFlipperActivity) context;
        TextView flipResult = coinFlipperActivity.findViewById(R.id.flipresult);
        Animation animFadeIn = AnimationUtils.loadAnimation(context, R.anim.fade_in);
        Animation animFadeOut = AnimationUtils.loadAnimation(context, R.anim.fade_out);



        switch (result){
            case"H":
                flipResult.startAnimation(animFadeIn);
                flipResult.setText(R.string.heads);
                break;
            case"T":
                flipResult.startAnimation(animFadeIn);
                flipResult.setText(R.string.tails);
                break;
            case"N":
                if(!flipResult.getText().toString().isEmpty()) {
                    flipResult.startAnimation(animFadeOut);
                }
                break;
            default:
                flipResult.setText(R.string.nice);
                Log.d("COIN_FLIPPER","case has gone wrong: " + result);
        }

    }

    @Override
    public void onItemClick(int position) {
    }
}
