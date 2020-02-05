package com.gr.light.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.trello.rxlifecycle3.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-03
 **/
public abstract class BaseActivity extends RxAppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
    }
    protected abstract int getLayoutId();
    //wocao

    //nimade
}
