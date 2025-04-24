package com.example.randomiser_app.ui.deckshuffler;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.widget.ImageView;

public class CardDrawAnimation {

    public interface AnimationCallback {
        void onAnimationEnd();
    }

    private ImageView lastRevealedCard;

    public void flipCard(final ImageView cardView, final int cardFrontResId, final AnimationCallback callback) {
        ObjectAnimator flipOut = ObjectAnimator.ofFloat(cardView, "rotationY", 0f, 90f);
        flipOut.setDuration(200);

        final ObjectAnimator flipIn = ObjectAnimator.ofFloat(cardView, "rotationY", -90f, 0f);
        flipIn.setDuration(200);

        flipOut.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                cardView.setImageResource(cardFrontResId);
                flipIn.start();
            }
        });

        flipIn.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                if (callback != null) callback.onAnimationEnd();
            }
        });

        flipOut.start();
    }

    public void revealCard(ImageView revealedCardView, ImageView deckView, int cardFrontResId) {

        revealedCardView.setImageDrawable(deckView.getDrawable());
        revealedCardView.setVisibility(View.VISIBLE);

        flipCard(revealedCardView, cardFrontResId, () -> {
            float targetY = deckView.getY() + 120f;
            moveCard(revealedCardView, deckView.getX(), targetY, null);
            lastRevealedCard = revealedCardView;
        });
    }

    public void moveCard(final View cardView, float toX, float toY, AnimationCallback callback) {
        cardView.animate()
                .x(toX)
                .y(toY)
                .setDuration(400)
                .setInterpolator(new AccelerateDecelerateInterpolator())
                .withEndAction(() -> {
                    if (callback != null) callback.onAnimationEnd();
                });
    }


    public void resetDeck(View deckView, ImageView revealedCardView) {
        if (revealedCardView != null) {
            revealedCardView.setVisibility(View.GONE);
        }
        deckView.setScaleX(1f);
        deckView.setScaleY(1f);
    }
}
