package com.milk.animation.v;

import android.animation.TypeEvaluator;
import android.graphics.PointF;

/**
 * 用途：
 * 作者：Created by liulei on 17/6/27.
 * 邮箱：liulei2@aixuedai.com
 */


public class PointEvaluator implements TypeEvaluator {
    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        PointF pointStar = (PointF) startValue;
        PointF pointEnd = (PointF) endValue;
        float x = (pointEnd.x - pointStar.x) * fraction + pointStar.x;
        float y = pointStar.y + (pointEnd.y - pointStar.y) * fraction;
        return new PointF(x, y);
    }
}
