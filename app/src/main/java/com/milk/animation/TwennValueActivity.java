package com.milk.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.animation.ValueAnimator.ofFloat;

/**
 * 用途：
 * 作者：Created by liulei on 17/6/23.
 * 邮箱：liulei2@aixuedai.com
 */


public class TwennValueActivity extends AppCompatActivity {


    @Bind(R.id.btn_money)
    Button mBtnMoney;
    @Bind(R.id.btn_vertical)
    Button mBtnVertical;
    @Bind(R.id.btn_parabolic)
    Button mBtnParabolic;
    @Bind(R.id.lyt_btn)
    LinearLayout mLytBtn;
    @Bind(R.id.iv_head)
    ImageButton mIvHead;
    @Bind(R.id.tv)
    TextView mTv;
    @Bind(R.id.btn_type_evaluator)
    Button mBtnTypeEvaluator;
    @Bind(R.id.btn_interpolator)
    Button mBtnInterpolator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_twenn_value);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.btn_money, R.id.btn_vertical, R.id.btn_parabolic})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_money:
                ValueAnimator valueAnimator = ofFloat(0f, 13456.5f);
                valueAnimator.setDuration(5000);
                valueAnimator.setInterpolator(new OvershootInterpolator());
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        float value = (float) animation.getAnimatedValue();
                        mTv.setText(String.format("%.2f", value));
                    }
                });
                valueAnimator.start();
                break;
            case R.id.btn_vertical:
                break;
            case R.id.btn_parabolic:
                break;
        }
    }

    @OnClick({R.id.btn_type_evaluator, R.id.btn_interpolator})
    public void onViewClickeds(View view) {
        switch (view.getId()) {
            case R.id.btn_type_evaluator:
//                ObjectAnimator valueAnimator = ObjectAnimator.ofFloat(mIvHead, "translationX", 1.0f, 240f);
//                valueAnimator.setDuration(3000);
//                valueAnimator.start();
                ValueAnimator valueAnimator = new ValueAnimator();
                valueAnimator.setDuration(10000);
                valueAnimator.setInterpolator(new LinearInterpolator());
                valueAnimator.setObjectValues(new PointF(0, 0));
                valueAnimator.setEvaluator(new TypeEvaluator() {
                    @Override
                    public Object evaluate(float fraction, Object startValue, Object endValue) {
                        Log.e("fraction", fraction * 3 + "");
                        PointF point = new PointF();
                        point.x = 200 * fraction * 3;
                        point.y = 0.5f * 200 * (fraction * 3) * (fraction * 3);
                        return point;
                    }
                });
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        PointF pointF = (PointF) animation.getAnimatedValue();
                        mIvHead.setX(pointF.x);
                        mIvHead.setY(pointF.y);
                    }
                });
                valueAnimator.start();
                break;
            case R.id.btn_interpolator:
                ObjectAnimator animatorX = ObjectAnimator.ofFloat(mIvHead, "scaleX", 1.0f, 1.5f);
                ObjectAnimator animatorY = ObjectAnimator.ofFloat(mIvHead, "scaleY", 1.0f, 1.5f);
                AnimatorSet set = new AnimatorSet();
                set.setDuration(2000);
                //具体路径可以自己把握
                set.setInterpolator(new BounceInterpolator());
                set.playTogether(animatorX, animatorY);
                set.start();
                break;
        }
    }

    public class SpringInterpolator implements Interpolator {
        private float factor;

        public SpringInterpolator(float factor) {
            this.factor = factor;
        }

        @Override
        public float getInterpolation(float x) {
            return (float) (Math.pow(2, -10 * x) * Math.sin((x - factor / 4) * (2 * Math.PI) / factor) + 1);
        }
    }
}
