package com.varyag.testworkoutapp.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.navigation.NavController;

import com.varyag.testworkoutapp.R;

public class DumbbelAnimation {
    public static void startDumbbellAnimation(ImageView dumbbellImageView, FrameLayout frameLayout, NavController navController) {
        dumbbellImageView.setTranslationY(0f);
        dumbbellImageView.setVisibility(View.INVISIBLE);

        ObjectAnimator fallAnimator1 = ObjectAnimator.ofFloat(frameLayout, "translationY", -100f, 0f);
        fallAnimator1.setDuration(700);
        AnimatorSet animatorSet1 = new AnimatorSet();
        animatorSet1.playSequentially(fallAnimator1);

        ObjectAnimator fallAnimator = ObjectAnimator.ofFloat(dumbbellImageView, "translationY", -100f, 0f);
        fallAnimator.setDuration(400);
        ObjectAnimator bounceAnimator1 = ObjectAnimator.ofFloat(dumbbellImageView, "translationY", 0f, -50f);
        bounceAnimator1.setDuration(300);

        ObjectAnimator bounceAnimator2 = ObjectAnimator.ofFloat(dumbbellImageView, "translationY", -50f, 0f);
        bounceAnimator2.setDuration(300);

        ObjectAnimator bounceAnimator3 = ObjectAnimator.ofFloat(dumbbellImageView, "translationY", 0f, -30f);
        bounceAnimator3.setDuration(250);

        ObjectAnimator returnAnimator = ObjectAnimator.ofFloat(dumbbellImageView, "translationY", -30f, 0f);
        returnAnimator.setDuration(200);

        AnimatorSet dumbbellAnimatorSet = new AnimatorSet();
        dumbbellAnimatorSet.playSequentially(fallAnimator, bounceAnimator1, bounceAnimator2, bounceAnimator3, returnAnimator);

        animatorSet1.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                dumbbellImageView.setVisibility(View.VISIBLE);
                dumbbellAnimatorSet.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        if (navController != null) {
                            navController.navigate(R.id.action_nav_home_to_nav_gallery2);
                        }
                    }
                });
                dumbbellAnimatorSet.start();
            }
        });

        animatorSet1.start();
    }
}
