package com.gr.mvpclean.presenter;

import android.app.Activity;

import androidx.annotation.NonNull;

import com.gr.mvpclean.activity.fragment.adapter.DiaryAdapter;
import com.gr.mvpclean.base.UseCase;
import com.gr.mvpclean.contract.DiaryContract;
import com.gr.mvpclean.data.DiaryRepository;
import com.gr.mvpclean.model.Diary;
import com.gr.mvpclean.usecase.GetAllDiaryUseCase;

import java.util.List;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-03-22
 **/
public class DiaryPresenter implements DiaryContract.Presenter {

    private final DiaryContract.View mView;
    private DiaryAdapter mAdapter;
    private GetAllDiaryUseCase mGetAllDiaryUseCase = new GetAllDiaryUseCase();

    public DiaryPresenter(DiaryContract.View diaryFragment){
        this.mView = diaryFragment; // 将传入的界面复制给日记的成员变量保存
    }

    @Override
    public void loadDiary() {
        mGetAllDiaryUseCase.setRequestValues(DiaryRepository.getInstance())
                .setUseCaseCallback(new UseCase.UseCaseCallback<List<Diary>>() {
                    @Override
                    public void onSuccess(List<Diary> response) {
                        if(!mView.isActive()){
                            return;
                        }
                        updateDiaryList(response);
                    }

                    @Override
                    public void onError() {
                        if(!mView.isActive()){
                            return;
                        }
                        mView.showError();
                    }
                }).run();
    }

    @Override
    public void addDiary() {
        mView .gotoWriteDiary();
    }

    @Override
    public void updateDiary(@NonNull Diary diary) {
        mView.gotoUpdateDiary(diary.getId());
    }

    @Override
    public void onResult(int requestCode, int reponseCode) {
        if(Activity.RESULT_OK != reponseCode){
            return;
        }
        mView.showSuccess();
    }

    @Override
    public void start() {
        initAdapter();
        loadDiary();
    }

    @Override
    public void destroy() {

    }

    private void initAdapter(){
        mAdapter = new DiaryAdapter();

        mAdapter.setOnLongClickListener((v,data) ->{
            updateDiary(data);
            return false;
        });

        mView.setAdapter(mAdapter);
    }

    private void updateDiaryList(List<Diary> diaryList){
        mAdapter.update(diaryList);
    }
}
