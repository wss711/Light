package com.jr.mvp.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.jr.mvp.R;
import com.jr.mvp.fragment.DiaryFragment;
import com.jr.mvp.utils.ActivityUtils;

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
        DiaryFragment diaryFragment = getDiaryFragment();   // 初始化Fragment
        if(diaryFragment == null){
            diaryFragment = new DiaryFragment();
            ActivityUtils.addFragment2Activity(getSupportFragmentManager(),diaryFragment,R.id.content);
        }
        diaryFragment.setPresenter(new DiaryPresenter(diaryFragment));
    }

    private DiaryFragment getDiaryFragment(){
        return (DiaryFragment)getSupportFragmentManager().findFragmentById(R.id.content);
    }
}
