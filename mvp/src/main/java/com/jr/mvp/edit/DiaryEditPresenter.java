package com.jr.mvp.edit;

import android.text.TextUtils;

import androidx.annotation.NonNull;

import com.google.gson.JsonPrimitive;
import com.jr.mvp.data.DiaryRepository;
import com.jr.mvp.data.source.DataCallback;
import com.jr.mvp.data.source.DataSource;
import com.jr.mvp.model.Diary;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-03-05
 **/
public class DiaryEditPresenter implements DiaryEditContract.Presenter {

    private final DataSource<Diary> mDiaryRepository;
    private final DiaryEditContract.View mView;
    private String mDiaryId;

    public DiaryEditPresenter(@NonNull DiaryEditContract.View addDiaryView, @NonNull String mDiaryId) {
        this.mView = addDiaryView;
        this.mDiaryId = mDiaryId;
        mDiaryRepository = DiaryRepository.getInstance();
    }

    @Override
    public void saveDiary(String title, String description) {
        if(isAddDiary()){
            createDiary(title,description);
        }else{
            updateDiary(title,description);
        }
    }

    private void createDiary(String title,String description){
        Diary newDiary = new Diary(title,description);
        mDiaryRepository.update(newDiary);
        mView.showDiaryList();
    }

    private void updateDiary(String title,String description){
        Diary newDiary = new Diary(title,description);
        mDiaryRepository.update(newDiary);
        mView.showDiaryList();
    }

    @Override
    public void requestDiary() {
        if(isAddDiary()){
            return;
        }

        mDiaryRepository.get(mDiaryId, new DataCallback<Diary>() {
            @Override
            public void onSuccess(Diary diary) {
                if(!mView.isActive()){
                    return;
                }
                mView.setTitle(diary.getTitle());
                mView.setDescription(diary.getDescription());
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
    public void start() {
        requestDiary();
    }

    @Override
    public void destroy() {

    }

    private boolean isAddDiary(){
        return TextUtils.isEmpty(mDiaryId);
    }
}
