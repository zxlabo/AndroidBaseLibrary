package com.demo.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;

/**
 * 心跳动画
 */
public class HeartBeatAnimationUtil {

    private View mTarget;
    private long mDuration = 100;
    private long mDelay = 1200;
    private float mFromScale = 1.0f;
    private float mToScale = 0.8f;

    private HeartBeatAnimationUtil(View target) {
        mTarget = target;
    }

    public static HeartBeatAnimationUtil with(View target) {
        return new HeartBeatAnimationUtil(target);
    }

    /**
     * 设置动画执行时间
     */
    public HeartBeatAnimationUtil duration(long duration) {
        mDuration = duration;
        return this;
    }

    /**
     * 设置心跳间隔
     */
    public HeartBeatAnimationUtil delay(long delay) {
        mDelay = delay;
        return this;
    }

    /**
     * 设置原始大小
     */
    public HeartBeatAnimationUtil scaleFrom(float fromScale) {
        mFromScale = fromScale;
        return this;
    }

    /**
     * 设置放大多少
     */
    public HeartBeatAnimationUtil scaleTo(float toScale) {
        mToScale = toScale;
        return this;
    }

    /**
     * Starts the animation.
     */
    public void start() {

//        ObjectAnimator increaseX = ObjectAnimator.ofFloat(mTarget, "scaleX", mFromScale, mToScale, mFromScale, mToScale);
//        ObjectAnimator increaseY =  ObjectAnimator.ofFloat(mTarget,"scaleY",mFromScale, mToScale, mFromScale, mToScale);
//        increaseX.setDuration(mDuration);
//        increaseY.setDuration(mDuration);
//
//        ObjectAnimator pause = ObjectAnimator.ofFloat(mTarget,"alpha",1,1,1);
//        pause.setDuration(mDelay);
//
//        ObjectAnimator decreaseX = ObjectAnimator.ofFloat(mTarget, "scaleX", mToScale, mFromScale, mToScale, mFromScale);
//        ObjectAnimator decreaseY =  ObjectAnimator.ofFloat(mTarget,"scaleY",mToScale, mFromScale, mToScale, mFromScale);
//        decreaseX.setDuration(mDuration);
//        decreaseY.setDuration(mDuration);
//
//
//
//        AnimatorSet animatorSet = new AnimatorSet();
//        animatorSet.
//        animatorSet.playSequentially();
        //        animatorSet.playSequentially(increaseAnimation,pause,decreaseAnimation);




//        new Sca()
//        animatorSet.play(increaseAnimation)
//        PropertyValuesHolder pvhIncreaseScaleX =
//                PropertyValuesHolder.ofFloat("scaleX", mFromScale, mToScale);
//        PropertyValuesHolder pvhIncreaseScaleY =
//                PropertyValuesHolder.ofFloat("scaleY", mFromScale, mToScale);
//        PropertyValuesHolder pvhDecreaseScaleX =
//                PropertyValuesHolder.ofFloat("scaleX", mToScale, mFromScale);
//        PropertyValuesHolder pvhDecreaseScaleY =
//                PropertyValuesHolder.ofFloat("scaleY", mToScale, mFromScale);
//
//        //变大
//        ObjectAnimator heartBeatIncreaseAnimator = ObjectAnimator.ofPropertyValuesHolder(
//                mTarget, pvhIncreaseScaleX, pvhIncreaseScaleY
//        );
//        heartBeatIncreaseAnimator.setStartDelay(mDelay);
//        heartBeatIncreaseAnimator.setDuration(mDuration);
//        heartBeatIncreaseAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
//        //缩小
//        ObjectAnimator heartBeatDecreaseAnimator = ObjectAnimator.ofPropertyValuesHolder(
//                mTarget, pvhDecreaseScaleX, pvhDecreaseScaleY
//        );
//        heartBeatDecreaseAnimator.setDuration(mDuration);
//        heartBeatDecreaseAnimator.setInterpolator(new AccelerateDecelerateInterpolator());

//        AnimatorSet heartBeatAnimatorSet = new AnimatorSet();
//        heartBeatAnimatorSet.playSequentially(heartBeatIncreaseAnimator, heartBeatDecreaseAnimator);
//        heartBeatAnimatorSet.addListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(Animator animation) {
//            }
//
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                animation.start();
//            }
//
//            @Override
//            public void onAnimationCancel(Animator animation) {
//            }
//
//            @Override
//            public void onAnimationRepeat(Animator animation) {
//            }
//        });
//        heartBeatAnimatorSet.start();
    }

}