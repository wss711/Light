package com.gr.light.patterns;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.gr.light.R;
import com.gr.light.activity.BaseActivity;

import butterknife.OnClick;

public class DesignPatternsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_design_patterns;
    }

    @OnClick({R.id.create_patterns_btn, R.id.struct_patterns_btn, R.id.behavior_patterns_btn,R.id.callback_patterns_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.create_patterns_btn:
                startActivity(new Intent(DesignPatternsActivity.this, CreatePatternsActivity.class));
                break;
            case R.id.struct_patterns_btn:
                startActivity(new Intent(DesignPatternsActivity.this,StructPatternsActivity.class));
                break;
            case R.id.behavior_patterns_btn:
                startActivity(new Intent(DesignPatternsActivity.this,BehaviorPatternsActivity.class));
                break;
            case R.id.callback_patterns_btn:
                startActivity(new Intent(DesignPatternsActivity.this,CallbackActivity.class));
                break;
        }
    }
}
