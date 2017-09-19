package com.milk.animation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 用途：
 * 作者：Created by liulei on 17/6/21.
 * 邮箱：liulei2@aixuedai.com
 */


public class TwennObjectActivity extends AppCompatActivity {
    @Bind(R.id.tv_alpha)
    Button mTvAlpha;
    @Bind(R.id.tv_translate)
    Button mTvTranslate;
    @Bind(R.id.tv_rotate)
    Button mTvRotate;
    @Bind(R.id.tv_scale)
    Button mTvScale;
    @Bind(R.id.iv_head)
    ImageView mIvHead;
    @Bind(R.id.tv_set)
    Button mTvSet;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_object);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_alpha, R.id.tv_translate, R.id.tv_rotate, R.id.tv_scale, R.id.tv_set, R.id.iv_head})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_alpha:
                Animation alphaAnimation = AnimationUtils.loadAnimation(this, R.anim.anime_alpha);
                mIvHead.startAnimation(alphaAnimation);
                break;
            case R.id.tv_translate:
                Animation translateAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_translate);
                mIvHead.startAnimation(translateAnimation);
                break;
            case R.id.tv_rotate:
                Animation rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
                mIvHead.startAnimation(rotateAnimation);
                break;
            case R.id.tv_scale:
                Animation scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
                mIvHead.startAnimation(scaleAnimation);
                break;
            case R.id.tv_set:
                Animation setAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_set);
                mIvHead.startAnimation(setAnimation);
                break;
            case R.id.iv_head:
                Toast.makeText(this, "你点到我啦", Toast.LENGTH_LONG).show();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
