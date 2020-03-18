package com.jr.mvp.edit;

import android.text.TextUtils;

import androidx.annotation.NonNull;

import com.google.gson.JsonPrimitive;
import com.jr.mvp.data.DiaryRepository;
import com.jr.mvp.data.source.DataCallback;
import com.jr.mvp.data.source.DataSource;
import com.jr.mvp.model.Diary;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-03-05
 **/
public class DiaryEditPresenter implements DiaryEditContract.Presenter {

    private final DataSource<Diary> mDiaryRepository;
    private final DiaryEditContract.View mView;
    private String mDiaryId;
    CompositeDisposable mCompositeDisposable;

    public DiaryEditPresenter(@NonNull DiaryEditContract.View addDiaryView, @NonNull String mDiaryId) {
        this.mView = addDiaryView;
        this.mDiaryId = mDiaryId;
        mDiaryRepository = DiaryRepository.getInstance();
        mCompositeDisposable = new CompositeDisposable();
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

        mCompositeDisposable.clear();
        Disposable disposable = mDiaryRepository
                .get(mDiaryId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    diary ->{
                        if(diary != null) {
                            if (!mView.isActive()) {
                                return;
                            }
                            mView.setTitle(diary.getTitle());
                            mView.setDescription(diary.getDescription());
                        }
                        else{
                            if(!mView.isActive()){
                                return;
                            }
                            mView.showError();
                        }
                    });

        mCompositeDisposable.add(disposable);
//        mDiaryRepository.get(mDiaryId, new DataCallback<Diary>() {
//            @Override
//            public void onSuccess(Diary diary) {
//                if(!mView.isActive()){
//                    return;
//                }
//                mView.setTitle(diary.getTitle());
//                mView.setDescription(diary.getDescription());
//            }
//
//            @Override
//            public void onError() {
//                if(!mView.isActive()){
//                    return;
//                }
//                mView.showError();
//            }
//        });
    }
    @Override
    public void subscribe() {
        requestDiary();
    }

    @Override
    public void unSubscribe() {
        mCompositeDisposable.clear();
    }

    private boolean isAddDiary(){
        return TextUtils.isEmpty(mDiaryId);
    }

}
