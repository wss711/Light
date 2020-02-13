package com.gr.light;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.gr.light.activity.BaseActivity;
import com.gr.light.advanceview.WssAdvanceViewActivity;
import com.gr.light.network.NetworkActivity;
import com.gr.light.patterns.DesignPatternsActivity;
import com.gr.light.permissions.PermissionsActivity;

import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @OnClick({R.id.advance_view_btn, R.id.permissions_btn,R.id.network_btn,R.id.patterns_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.advance_view_btn:
                startActivity(new Intent(MainActivity.this, WssAdvanceViewActivity.class));
                break;
            case R.id.permissions_btn:
                startActivity(new Intent(MainActivity.this, PermissionsActivity.class));
                break;
            case R.id.network_btn:
                startActivity(new Intent(MainActivity.this, NetworkActivity.class));
                break;
            case R.id.patterns_btn:
                startActivity(new Intent(MainActivity.this, DesignPatternsActivity.class));
                break;


                default:
                    break;
        }
    }
}
