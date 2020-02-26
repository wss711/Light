package com.gr.mvcnote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.os.Bundle;

import com.gr.mvcnote.fragment.DiaryFragment;
import com.gr.mvcnote.utils.ActivityUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 初始化顶栏（Toolbar）
        initToolBar();
        // 初始化Fragment，Fragment用来管理View
        initFragment();
    }

    private void initToolBar(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); // 自定义顶部导航栏Toolbar为ActionBar
    }

    private void initFragment(){
        DiaryFragment diaryFragment = getDiaryFragment();
        if(diaryFragment == null){
            diaryFragment = new DiaryFragment();
            // 将日记Fragment添加到Activity显示
            ActivityUtils.addFragment2Activity(getSupportFragmentManager(),diaryFragment,R.id.content);
        }
    }

    private DiaryFragment getDiaryFragment(){
        // 通过FragmentManager查找日记展示Fragment
        return (DiaryFragment) getSupportFragmentManager().findFragmentById(R.id.content);
    }
}
