package com.gr.mvpclean.edit;

import androidx.annotation.NonNull;

import com.gr.mvpclean.base.UseCase;
import com.gr.mvpclean.data.DiaryRepository;
import com.gr.mvpclean.edit.usecase.GetDiaryUseCase;
import com.gr.mvpclean.edit.usecase.UpdateDiaryUseCase;
import com.gr.mvpclean.model.Diary;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-03-23
 **/
public class DiaryEditPresenter implements DiaryEditContract.Presenter {

    private final DiaryEditContract.View mView;
    private String mDiaryId;

    private GetDiaryUseCase mGetDiaryUseCase = new GetDiaryUseCase();
    private UpdateDiaryUseCase mUpdateDiaryUseCase = new UpdateDiaryUseCase();

    public DiaryEditPresenter(@NonNull String diaryId, @NonNull DiaryEditContract.View addDiaryView) {
        this.mDiaryId = diaryId;
        this.mView = addDiaryView;
    }

    @Override
    public void saveDiary(String title, String description) {
        mUpdateDiaryUseCase.setRequestValues(
                new UpdateDiaryUseCase.RequestValues(mDiaryId,
                                                        title,
                                                        description,
                                                        DiaryRepository.getInstance()
                )
        ).setUseCaseCallback(new UseCase.UseCaseCallback<Void>() {
            @Override
            public void onSuccess(Void response) {
                mView.showDiaryList();
            }

            @Override
            public void onError() {

            }
        }).run();
    }

    @Override
    public void requestDiary() {
        mGetDiaryUseCase.setRequestValues(
                new GetDiaryUseCase.RequestValues(mDiaryId, DiaryRepository.getInstance()))
                .setUseCaseCallback(new UseCase.UseCaseCallback<Diary>() {
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
                }).run();
    }

    @Override
    public void start() {
        requestDiary();
    }

    @Override
    public void destroy() {

    }
}
