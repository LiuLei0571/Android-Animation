package com.milk.animation.v;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.milk.animation.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 用途：
 * 作者：Created by liulei on 17/6/27.
 * 邮箱：liulei2@aixuedai.com
 */


public class VAnimationActivity extends AppCompatActivity {
    @Bind(R.id.btn_star)
    Button mBtnStar;
    private CircleView mCircleView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_v);
        ButterKnife.bind(this);
        mCircleView = (CircleView) findViewById(R.id.circle);
     }

    @OnClick(R.id.btn_star)
    public void onViewClicked() {
        mCircleView.star();

    }
}
