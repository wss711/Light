package com.gr.light.advanceview.cardview;

import android.os.Bundle;
import android.widget.SeekBar;

import androidx.cardview.widget.CardView;

import com.gr.light.R;
import com.gr.light.activity.BaseActivity;

import butterknife.BindView;

public class WssCardViewActivity extends BaseActivity {

    @BindView(R.id.card_view)
    CardView cardView;
    @BindView(R.id.corner_cardview_sb)
    SeekBar cornerSb;
    @BindView(R.id.shadow_cardview_sb)
    SeekBar shadowSb;
    @BindView(R.id.img_interval_cardview_sb)
    SeekBar imgIntervalSb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initDatas();
        initView();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_wss_card_view;
    }

    private void initDatas() {

    }

    private void initView() {
        cornerSb .setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                cardView.setRadius(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        shadowSb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                cardView.setCardElevation(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        imgIntervalSb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                cardView.setContentPadding(progress,progress,progress,progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

}
