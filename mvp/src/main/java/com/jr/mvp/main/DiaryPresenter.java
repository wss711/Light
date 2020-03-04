package com.jr.mvp.main;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jr.mvp.data.DiaryRepository;
import com.jr.mvp.main.list.DiaryAdapter;
import com.jr.mvp.model.Diary;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-03-03
 **/
public class DiaryPresenter implements DiaryContract.Presenter{

    private final DiaryRepository mDiaryRepository;
    private final DiaryContract.View mView;
    private DiaryAdapter mDiaryAdapter;

    public DiaryPresenter(@NonNull DiaryContract.View diaryFragment){
        mDiaryRepository = DiaryRepository.getInstance();
        mView = diaryFragment;
    }

    @Override
    public void start() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void loadDiary() {

    }

    @Override
    public void addDiary() {

    }

    @Override
    public void updateDiary(@NonNull Diary diary) {
        mView.gotoUpdateDiary(diary.getId());
    }

    @Override
    public void onResult(int requestCode, int resultCode) {

    }


    private void initAdapter(){
        mDiaryAdapter = new DiaryAdapter();
        mDiaryAdapter.setOnLongClickListener(new DiaryAdapter.OnLongClickListener<Diary>() {
            @Override
            public boolean onLongClick(View v, Diary data) {
                updateDiary();
                return false;
            }
        });
        mView.setListAdapter(mDiaryAdapter);
    }


}
