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


        initToolBar();

        initFragment();
    }

    private void initToolBar(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void initFragment(){
        DiaryFragment diaryFragment = getDiaryFragment();

        if(diaryFragment == null){
            diaryFragment = new DiaryFragment();
            ActivityUtils.addFragment2Activity(getSupportFragmentManager(),diaryFragment,R.id.content);
        }
    }

    private DiaryFragment getDiaryFragment(){
        return (DiaryFragment) getSupportFragmentManager().findFragmentById(R.id.content);
    }
}
