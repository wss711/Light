package com.gr.light.patterns;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.gr.light.R;
import com.gr.light.activity.BaseActivity;
import com.gr.light.patterns.decorator.Client;
import com.gr.light.patterns.proxy.ProxyClient;
import com.gr.light.patterns.proxy.compulsiveproxy.ComplusiveProxyPatternsClient;
import com.gr.light.patterns.proxy.normalproxy.GamePlayerProxy;
import com.gr.light.patterns.proxy.normalproxy.IGamePlayer;
import com.gr.light.patterns.proxy.normalproxy.ProxyNormalPatternsClient;

import butterknife.OnClick;

public class StructPatternsActivity extends BaseActivity {

    private final static String TAG = "DP";

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
                Log.i(TAG,"======== Initial Proxy Patterns ==========");
                ProxyClient.execute();
                Log.i(TAG,"======== Normal Proxy Patterns ==========");
                ProxyNormalPatternsClient.execute();
                Log.i(TAG,"======== Complusive Proxy Patterns ==========");
                ComplusiveProxyPatternsClient.execute();
                break;
            case R.id.adapter_patterns_btn:
                com.gr.light.patterns.adapter.Client.execute();
                break;
            case R.id.decorator_patterns_btn:
                Client.execute();
                break;
            case R.id.facade_patterns_btn:
                break;
            case R.id.bridge_patterns_btn:
                break;
            case R.id.compose_patterns_btn:
                com.gr.light.patterns.compose.Client.execute();
                break;
            case R.id.flyweight_patterns_btn:
                break;
        }
    }


}
