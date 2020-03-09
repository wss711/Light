package com.jr.mvp.edit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.text.TextUtils;


import com.jr.mvp.R;
import com.jr.mvp.model.Diary;
import com.jr.mvp.utils.ActivityUtils;

public class DiaryEditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_edit);

        // 获取上一级页面管理的DiaryFragment跳转过来时携带的参数----日记id
        String diaryId = getIntent().getStringExtra(DiaryEditFragment.DIARY_ID);

        // 初始化顶栏，通过日记Id，对顶部导航栏Toolbar进行设置。
        initToolbar(diaryId);

        // 初始化Fragment
        initFragment(diaryId);

    }

    private void initToolbar(String diaryId){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setToolbarTitle(TextUtils.isEmpty(diaryId));
    }

    private void setToolbarTitle(boolean isAdd){
        if(isAdd){
            getSupportActionBar().setTitle(R.string.add);
        }else{
            getSupportActionBar().setTitle(R.string.edit);
        }
    }

    private void initFragment(String diaryId){
        DiaryEditFragment diaryEditFragment = getDiaryEditFragment();
        if(diaryEditFragment == null){
            diaryEditFragment = initEditDiaryFragment(diaryId);
        }

        DiaryEditPresenter diaryEditPresenter = new DiaryEditPresenter(diaryEditFragment,diaryId);
        diaryEditFragment.setPresenter(diaryEditPresenter);
    }

    @NonNull
    private DiaryEditFragment initEditDiaryFragment(String diaryId){
        DiaryEditFragment diaryEditFragment = new DiaryEditFragment();
        if(getIntent().hasExtra(DiaryEditFragment.DIARY_ID)){
            Bundle bundle = new Bundle();
            bundle.putString(DiaryEditFragment.DIARY_ID,diaryId);
            diaryEditFragment.setArguments(bundle);
        }

        ActivityUtils.addFragment2Activity(getSupportFragmentManager(),diaryEditFragment,R.id.content);

        return diaryEditFragment;
    }

    private DiaryEditFragment getDiaryEditFragment(){
        return (DiaryEditFragment)getSupportFragmentManager().findFragmentById(R.id.content);
    }
}
