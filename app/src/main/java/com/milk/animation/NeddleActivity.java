package com.milk.animation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import static com.milk.animation.R.layout.activity_neddle;

/**
 * 用途：
 * 作者：Created by liulei on 17/6/21.
 * 邮箱：liulei2@aixuedai.com
 */


public class NeddleActivity extends AppCompatActivity {
    private ImageView mIv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_neddle);
        mIv = (ImageView) findViewById(R.id.iv_head);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        AnimationDrawable animation = (AnimationDrawable) mIv.getDrawable();
        animation.start();
    }
}

