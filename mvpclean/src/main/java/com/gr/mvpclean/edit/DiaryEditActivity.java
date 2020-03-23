package com.gr.mvpclean.edit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.text.TextUtils;

import com.gr.mvpclean.R;
import com.gr.mvpclean.model.Diary;
import com.gr.mvpclean.utils.ActivityUtils;

public class DiaryEditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_edit);

        String diaryId = getIntent().getStringExtra(DiaryEditFragment.DIARY_ID);

        initToolbar(diaryId);

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
        DiaryEditFragment addDiaryEditFragment = getDiaryEditFragment();
        if(addDiaryEditFragment == null){
            addDiaryEditFragment = initEditDiaryFragment(diaryId);
        }

        //
        DiaryEditPresenter diaryEditPresenter = new DiaryEditPresenter(diaryId, addDiaryEditFragment);

        // 将创建的Presenter传入Fragment
        addDiaryEditFragment.setPresenter(diaryEditPresenter);

    }

    private DiaryEditFragment initEditDiaryFragment(String diaryId){

        // 创建修改日记的Fragment
        DiaryEditFragment addEditDiaryFragment = new DiaryEditFragment();

        // 将日记的唯一标识保存到日记Fragment的Arguments
        if(getIntent().hasExtra(DiaryEditFragment.DIARY_ID)){
            Bundle bundle = new Bundle();
            bundle.putString(DiaryEditFragment.DIARY_ID,diaryId);
            addEditDiaryFragment.setArguments(bundle);
        }

        //  将日记Fragment添加到Activity显示
        ActivityUtils.addFragment2Activity(getSupportFragmentManager(),addEditDiaryFragment,R.id.content);

        return addEditDiaryFragment;
    }

    private DiaryEditFragment getDiaryEditFragment() { // 通过FragmentManager查找日记展示Fragment
        return (DiaryEditFragment) getSupportFragmentManager().findFragmentById(R.id.content);
    }

}
