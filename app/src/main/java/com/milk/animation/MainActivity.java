package com.milk.animation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.btn_tween)
    Button mBtnTween;
    @Bind(R.id.btn_needle)
    Button mBtnNeedle;
    @Bind(R.id.btn_property)
    Button mBtnProperty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_tween, R.id.btn_needle, R.id.btn_property})
    public void onViewClicked(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.btn_tween:
                intent = new Intent(this, PropertyActivity.class);
                break;
            case R.id.btn_needle:
                intent = new Intent(this, NeddleActivity.class);
                break;
            case R.id.btn_property:
                intent = new Intent(this, TwennActivity.class);
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
