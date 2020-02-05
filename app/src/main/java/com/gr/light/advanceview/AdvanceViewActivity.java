package com.gr.light.advanceview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gr.light.MainActivity;
import com.gr.light.R;
import com.gr.light.activity.BaseActivity;
import com.gr.light.advanceview.gridview.WssGridViewActivity;
import com.gr.light.advanceview.listview.WssListViewActivity;
import com.gr.light.advanceview.recyclerview.WssRecyclerViewActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class AdvanceViewActivity extends BaseActivity {

    @BindView(R.id.listview_btn)
    Button listviewBtn;
    @BindView(R.id.gridview_btn)
    Button gridviewBtn;
    @BindView(R.id.recyclerview_btn)
    Button recyclerviewBtn;
    @BindView(R.id.cardview_btn)
    Button cardviewBtn;
    @BindView(R.id.viewpager_btn)
    Button viewpagerBtn;
    @BindView(R.id.bottomNavigation_view_btn)
    Button bottomNavigationViewBtn;
    @BindView(R.id.tablayout_btn)
    Button tablayoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_advance_view;
    }

    @OnClick({R.id.listview_btn, R.id.gridview_btn, R.id.recyclerview_btn, R.id.cardview_btn, R.id.viewpager_btn, R.id.bottomNavigation_view_btn, R.id.tablayout_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.listview_btn:
                startActivity(new Intent(AdvanceViewActivity.this, WssListViewActivity.class));
                break;
            case R.id.gridview_btn:
                startActivity(new Intent(AdvanceViewActivity.this, WssGridViewActivity.class));
                break;
            case R.id.recyclerview_btn:
                startActivity(new Intent(AdvanceViewActivity.this, WssRecyclerViewActivity.class));
                break;
            case R.id.cardview_btn:
                break;
            case R.id.viewpager_btn:
                break;
            case R.id.bottomNavigation_view_btn:
                break;
            case R.id.tablayout_btn:
                break;
        }
    }
}
