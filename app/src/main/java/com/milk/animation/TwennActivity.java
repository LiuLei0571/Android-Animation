package com.milk.animation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.milk.animation.v.VAnimationActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 用途：
 * 作者：Created by liulei on 17/6/23.
 * 邮箱：liulei2@aixuedai.com
 */


public class TwennActivity extends AppCompatActivity {
    @Bind(R.id.object)
    Button mBtnObject;
    @Bind(R.id.value)
    Button mBtnValue;
    @Bind(R.id.v)
    Button mBtnV;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.object, R.id.value, R.id.v})
    public void onViewClicked(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.object:
                intent = new Intent(this, TwennObjectActivity.class);
                break;
            case R.id.value:
                intent = new Intent(this, TwennValueActivity.class);
                break;
            case R.id.v:
                intent = new Intent(this, VAnimationActivity.class);
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}
