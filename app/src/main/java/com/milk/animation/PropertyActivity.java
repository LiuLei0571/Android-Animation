package com.milk.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 用途：
 * 作者：Created by liulei on 17/6/21.
 * 邮箱：liulei2@aixuedai.com
 */


public class PropertyActivity extends AppCompatActivity {
    @Bind(R.id.tv_alpha)
    Button mTvAlpha;
    @Bind(R.id.tv_translate)
    Button mTvTranslate;
    @Bind(R.id.tv_rotate)
    Button mTvRotate;
    @Bind(R.id.tv_scale)
    Button mTvScale;
    @Bind(R.id.tv_set)
    Button mTvSet;
    @Bind(R.id.iv_head)
    ImageView mIvHead;
    int i;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);
        ButterKnife.bind(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @OnClick({R.id.tv_alpha, R.id.tv_translate, R.id.tv_rotate, R.id.tv_scale, R.id.tv_set, R.id.iv_head})
    public void onViewClicked(final View view) {
        switch (view.getId()) {
            case R.id.tv_alpha:
                Animator animatorAlpha = AnimatorInflater.loadAnimator(this, R.animator.animator_alpha);
                animatorAlpha.setTarget(mIvHead);
                animatorAlpha.start();
//                ObjectAnimator alphaAnimator=ObjectAnimator.ofFloat(mIvHead,"alpha",0,90);
//                alphaAnimator.setDuration(500).setRepeatMode(ValueAnimator.REVERSE);
//                alphaAnimator.setRepeatCount(1);
//                alphaAnimator.start();
                break;
            case R.id.tv_translate:
                Animator animatorTranslate = AnimatorInflater.loadAnimator(this, R.animator.animator_translate);
                animatorTranslate.setTarget(mIvHead);
                animatorTranslate.start();
                break;
            case R.id.tv_rotate:
                final ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mTvAlpha, "alpha", 1.0f, 0.2f);
                objectAnimator.setDuration(3000);
                objectAnimator.start();
                objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        float cVal = (float) objectAnimator.getAnimatedValue();

                        Log.d("tags", String.valueOf(cVal));
                    }
                });
                objectAnimator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        Log.d("tags", "开始动画");

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        Log.d("tags", "结束动画");

                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                        Log.d("tags", "取消动画");

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });

                break;
            case R.id.tv_scale:
                PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.5f);
                PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.5f);
                PropertyValuesHolder alpha = PropertyValuesHolder.ofFloat("alpha", 1.0f, 0.2f);
                ObjectAnimator objectAnimator1 = ObjectAnimator.ofPropertyValuesHolder(mIvHead, scaleX, scaleY, alpha);
                objectAnimator1.setDuration(3000).start();
                break;
            case R.id.tv_set:
                Animator animatorSet = AnimatorInflater.loadAnimator(this, R.animator.animator_set);
                animatorSet.setTarget(mIvHead);
                animatorSet.start();
                break;
            case R.id.iv_head:
                break;
        }
    }
}
