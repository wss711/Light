package com.gr.light.patterns;

import android.os.Bundle;
import android.view.View;

import com.gr.light.R;
import com.gr.light.activity.BaseActivity;
import com.gr.light.patterns.simplefactory.ComputerFactory;
import com.gr.light.patterns.singleton.HungrySingleton;

import butterknife.OnClick;

public class BuilderPatternsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_builder_patterns;
    }

    @OnClick({R.id.singleton_patterns_btn, R.id.simple_factory_patterns_btn, R.id.static_factory_patterns_btn, R.id.factory_patterns_btn, R.id.builder_patterns_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.singleton_patterns_btn:
                HungrySingleton.getInstance().print("HungrySingleton");
                break;
            case R.id.simple_factory_patterns_btn:
                ComputerFactory.createComputer("戴尔").start();
                break;
            case R.id.static_factory_patterns_btn:
                break;
            case R.id.factory_patterns_btn:
                break;
            case R.id.builder_patterns_btn:
                break;
        }
    }




}
