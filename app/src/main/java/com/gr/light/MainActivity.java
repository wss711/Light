package com.gr.light;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.gr.light.activity.BaseActivity;
import com.gr.light.advanceview.AdvanceViewActivity;
import com.gr.light.advanceview.listview.WssListViewActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.advance_view_btn)
    Button advanceViewBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @OnClick(R.id.advance_view_btn)
    public void onClick() {
        startActivity(new Intent(MainActivity.this, AdvanceViewActivity.class));
    }
}
