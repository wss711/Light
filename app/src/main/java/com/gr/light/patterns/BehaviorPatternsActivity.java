package com.gr.light.patterns;

import android.os.Bundle;
import android.view.View;

import com.gr.light.R;
import com.gr.light.activity.BaseActivity;
import com.gr.light.patterns.template.BenzCarModel;
import com.gr.light.patterns.template.BmwCarModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import butterknife.OnClick;

public class BehaviorPatternsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_behavior_patterns;
    }

    @OnClick({R.id.template_patterns_btn, R.id.Strategy_patterns_btn, R.id.observer_patterns_btn,
            R.id.iterator_patterns_btn, R.id.chain_patterns_btn, R.id.command_patterns_btn,
            R.id.memento_patterns_btn, R.id.state_patterns_btn, R.id.visitor_patterns_btn,
            R.id.mediator_patterns_btn, R.id.interpreter_patterns_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.template_patterns_btn:
                System.out.println("---------- BMW ----------");
                BmwCarModel bmwCarModel = new BmwCarModel();
                // 不要喇叭
                bmwCarModel.setAlarm(false);
                bmwCarModel.run();
                // 要喇叭
                bmwCarModel.setAlarm(true);
                bmwCarModel.run();

                System.out.println("---------- Benz ----------");
                new BenzCarModel().run();

                break;
            case R.id.Strategy_patterns_btn:
                break;
            case R.id.observer_patterns_btn:
                break;
            case R.id.iterator_patterns_btn:
                break;
            case R.id.chain_patterns_btn:
                break;
            case R.id.command_patterns_btn:
                break;
            case R.id.memento_patterns_btn:
                break;
            case R.id.state_patterns_btn:
                break;
            case R.id.visitor_patterns_btn:
                break;
            case R.id.mediator_patterns_btn:
                break;
            case R.id.interpreter_patterns_btn:
                break;
        }
    }
}
