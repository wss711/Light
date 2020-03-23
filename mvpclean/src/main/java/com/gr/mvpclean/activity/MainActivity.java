package com.gr.mvpclean.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.os.Bundle;

import com.gr.mvpclean.R;
import com.gr.mvpclean.activity.fragment.DiaryFragment;
import com.gr.mvpclean.presenter.DiaryPresenter;
import com.gr.mvpclean.utils.ActivityUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolbar();
        initFragment();

    }

    private void initToolbar(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void initFragment(){
        DiaryFragment diaryFragment = getDiariesFragment();
        if(diaryFragment == null){
            diaryFragment = new DiaryFragment();
            ActivityUtils.addFragment2Activity(getSupportFragmentManager(),diaryFragment,R.id.content);
        }

        diaryFragment.setPresenter(new DiaryPresenter(diaryFragment));

    }

    private DiaryFragment getDiariesFragment() {
        // 通过FragmentManager查找日记展示Fragment
        return (DiaryFragment) getSupportFragmentManager().findFragmentById(R.id.content);
    }

}
