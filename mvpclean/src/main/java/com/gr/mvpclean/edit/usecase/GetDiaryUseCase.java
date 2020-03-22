package com.gr.mvpclean.edit.usecase;

import android.text.TextUtils;

import com.gr.mvpclean.base.UseCase;
import com.gr.mvpclean.data.DiaryRepository;
import com.gr.mvpclean.data.source.DataCallback;
import com.gr.mvpclean.model.Diary;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-03-22
 **/
public class GetDiaryUseCase extends UseCase<GetDiaryUseCase.RequestValues, Diary> {
    @Override
    protected void executeUseCase(RequestValues requestValues) {

        if(isAddDiary()){ // 日记id为空，则返回，添加日记，不作查询处理
            return;
        }

        getRequestValues().diaryRepository.get(getRequestValues().diaryId, new DataCallback<Diary>() {

            @Override
            public void onSuccess(Diary diary) { //  获取成功
                getUseCaseCallback().onSuccess(diary);
            }

            @Override
            public void onError() { //  获取失败
                getUseCaseCallback().onError();
            }
        });
    }

    private boolean isAddDiary(){   // 是否是添加日记
        return TextUtils.isEmpty(getRequestValues().diaryId); // id为空则为添加日记
    }

    /** 创建静态内部类，声明日记id和数据仓库，供该UseCase使用 */
    public static class RequestValues implements UseCase.RequestValues{

        private String diaryId;
        private DiaryRepository diaryRepository;

        public RequestValues(String diaryId,DiaryRepository diaryRepository){
            this.diaryId = diaryId;
            this.diaryRepository = diaryRepository;
        }
    }
}
