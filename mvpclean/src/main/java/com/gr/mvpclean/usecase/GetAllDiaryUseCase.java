package com.gr.mvpclean.usecase;

import com.gr.mvpclean.base.UseCase;
import com.gr.mvpclean.data.DiaryRepository;
import com.gr.mvpclean.data.source.DataCallback;
import com.gr.mvpclean.model.Diary;

import java.util.List;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-03-22
 **/
public class GetAllDiaryUseCase extends UseCase<DiaryRepository, List<Diary>> {

    @Override
    protected void executeUseCase(DiaryRepository requestValues) {

        // 通过数据仓库获取数据
        requestValues.getAll(new DataCallback<List<Diary>>() {
            @Override
            public void onSuccess(List<Diary> diaryList) {
                getUseCaseCallback().onSuccess(diaryList);
            }

            @Override
            public void onError() {
                getUseCaseCallback().onError();
            }

        });
    }
}
