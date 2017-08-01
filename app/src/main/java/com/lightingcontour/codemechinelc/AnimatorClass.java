package com.lightingcontour.codemechinelc;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

/**
 * Created by lich6389 on 2017/7/25.
 */

/*
* 动画类，用于存放各种动画方法.
* */
public class AnimatorClass {
    public static void clickAnimator(View view)
    {
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(view,"scaleX",1f,1.2f,1f);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(view,"scaleY",1f,1.2f,1f);
        animatorX.setDuration(500);
        animatorX.setInterpolator(new BounceInterpolator());
        animatorX.start();
        animatorY.setDuration(500);
        animatorY.setInterpolator(new BounceInterpolator());
        animatorY.start();
    }
}
