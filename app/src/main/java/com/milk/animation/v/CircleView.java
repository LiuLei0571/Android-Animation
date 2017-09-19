package com.milk.animation.v;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;

import com.milk.animation.R;

/**
 * 用途：
 * 作者：Created by liulei on 17/6/27.
 * 邮箱：liulei2@aixuedai.com
 */


public class CircleView extends View {
    private Context mContext;
    private Paint mPaint;
    private int mDefaultColor;
    private float mRadius;
    private float xPoint;
    private PointF pointFirst;
    private PointF pointSecond;
    private float mScreenX;
    private float mScreenY;
    private float top;
    private float left;
    private float right;
    private float bootom;

    public CircleView(Context context) {
        this(context, null);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        mContext = context;
        TypedArray ta = mContext.obtainStyledAttributes(attrs, R.styleable.CircleView);
        mDefaultColor = ta.getColor(R.styleable.CircleView_v_color, Color.BLACK);
        mRadius = ta.getDimension(R.styleable.CircleView_radius, 5);
        pointFirst = new PointF();
        pointSecond = new PointF();
        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        mScreenX = dm.widthPixels;
        mScreenY = dm.heightPixels;
        top = getTop();
        ta.recycle();
    }

    public void star() {
//        ValueAnimator valueAnimator = ValueAnimator.ofFloat(mRadius,mScreenX-mRadius);
//        valueAnimator.setDuration(3000);
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//
//            public void onAnimationUpdate(ValueAnimator animation) {
//                Log.d("animation", animation.getAnimatedValue() + "");
//                xPoint = (float) animation.getAnimatedValue();
//                invalidate();
//            }
//        });
        AnimatorSet animSet = new AnimatorSet();
        animSet.setDuration(5000);
        ValueAnimator valueAnimatorFirst = ValueAnimator.ofObject(new PointEvaluator(), new PointF(mRadius, mRadius), new PointF(mScreenX / 2, mScreenY / 3 * 2 - mRadius));
        valueAnimatorFirst.setDuration(5000);
        valueAnimatorFirst.setEvaluator(new PointEvaluator());
        valueAnimatorFirst.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                pointFirst = (PointF) animation.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimatorFirst.start();

        ValueAnimator valueAnimatorSecond = ValueAnimator.ofObject(new PointEvaluator(), new PointF(mScreenX / 2, mScreenY / 3 * 2 - mRadius), new PointF(mScreenX - mRadius, mRadius));
        valueAnimatorFirst.setDuration(5000);
        valueAnimatorSecond.setEvaluator(new PointEvaluator());
        valueAnimatorSecond.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                pointFirst = (PointF) animation.getAnimatedValue();
//                Log.d("pointFirst", pointFirst.x + "");
                invalidate();
            }
        });
        animSet.play(valueAnimatorSecond).after(valueAnimatorFirst);
        animSet.setInterpolator(new LinearInterpolator());
        animSet.start();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mPaint == null) {
            mPaint = new Paint();
        }
        mPaint.setColor(mDefaultColor);
        mPaint.setAntiAlias(true);
//        canvas.drawCircle(xPoint, mRadius, mRadius, mPaint);
        canvas.drawCircle(pointFirst.x, pointFirst.y, mRadius, mPaint);
        canvas.drawLine(mRadius, mRadius, pointFirst.x, pointFirst.y, mPaint);

    }

    public int dip2px(float dpValue) {
        float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
