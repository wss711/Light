package com.gr.light;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gr.light.activity.BaseActivity;
import com.gr.light.advanceview.AdvanceViewActivity;
import com.gr.light.notification.WssNotificationActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.advance_view_btn)
    Button advanceViewBtn;
    @BindView(R.id.notification_btn)
    Button notificationBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @OnClick({R.id.advance_view_btn, R.id.notification_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.advance_view_btn:
                startActivity(new Intent(MainActivity.this, AdvanceViewActivity.class));
                break;
            case R.id.notification_btn:
                startActivity(new Intent(MainActivity.this, WssNotificationActivity.class));
                break;
        }
    }
}
