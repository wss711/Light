package com.gr.light.patterns;

import android.os.Bundle;
import android.view.View;

import com.gr.light.R;
import com.gr.light.activity.BaseActivity;
import com.gr.light.patterns.proxy.ProxyClient;

import butterknife.OnClick;

public class StructPatternsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_struct_patterns;
    }

    @OnClick({R.id.proxy_patterns_btn, R.id.adapter_patterns_btn, R.id.decorator_patterns_btn,
            R.id.facade_patterns_btn, R.id.bridge_patterns_btn, R.id.compose_patterns_btn,
            R.id.flyweight_patterns_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.proxy_patterns_btn:
                ProxyClient.execute();
                break;
            case R.id.adapter_patterns_btn:
                break;
            case R.id.decorator_patterns_btn:
                break;
            case R.id.facade_patterns_btn:
                break;
            case R.id.bridge_patterns_btn:
                break;
            case R.id.compose_patterns_btn:
                break;
            case R.id.flyweight_patterns_btn:
                break;
        }
    }


}
