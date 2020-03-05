package com.jr.mvp.main;

import android.app.Activity;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jr.mvp.data.DiaryRepository;
import com.jr.mvp.data.source.DataCallback;
import com.jr.mvp.main.list.DiaryAdapter;
import com.jr.mvp.model.Diary;

import java.util.List;

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
        initAdapter();
        loadDiary();
    }

    @Override
    public void destroy() {

    }

    @Override
    public void loadDiary() {
        mDiaryRepository.getAll(new DataCallback<List<Diary>>() {
            @Override
            public void onSuccess(List<Diary> diaryList) {
                if(!mView.isActive()){
                    return;
                }
                updateDiaryList(diaryList);
            }

            @Override
            public void onError() {
                if(!mView.isActive()){
                    return;
                }
                mView.showError();
            }
        });
    }

    @Override
    public void addDiary() {
        mView.gotoWriteDiary();
    }

    @Override
    public void updateDiary(@NonNull Diary diary) {
        mView.gotoUpdateDiary(diary.getId());
    }

    @Override
    public void onResult(int requestCode, int resultCode) {
        if(Activity.RESULT_OK != resultCode){
            return;
        }
        mView.showSuccess();
    }

    private void initAdapter(){
        mDiaryAdapter = new DiaryAdapter();
        mDiaryAdapter.setOnLongClickListener(new DiaryAdapter.OnLongClickListener<Diary>() {
            @Override
            public boolean onLongClick(View v, Diary diary) {
                updateDiary(diary);
                return false;
            }
        });
        mView.setListAdapter(mDiaryAdapter);
    }

    private void updateDiaryList(List<Diary> diaryList){
        mDiaryAdapter.update(diaryList);
    }
}
