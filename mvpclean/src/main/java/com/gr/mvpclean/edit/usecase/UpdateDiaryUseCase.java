package com.gr.mvpclean.edit.usecase;

import android.text.TextUtils;

import com.gr.mvpclean.base.UseCase;
import com.gr.mvpclean.data.DiaryRepository;
import com.gr.mvpclean.model.Diary;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-03-22
 **/
public class UpdateDiaryUseCase extends UseCase<UpdateDiaryUseCase.RequestValues,Void> {
    @Override
    protected void executeUseCase(RequestValues requestValues) {
        if(isAddDiary()){ // 是否是添加日记
            createDiary(getRequestValues().title,getRequestValues().description);
        }else {
            updateDiary(getRequestValues().title,getRequestValues().description);
        }
    }

    private boolean isAddDiary(){
        return TextUtils.isEmpty(getRequestValues().id); //id为空则为添加日记
    }

    private void createDiary(String title,String description){
        Diary newDiary = new Diary(title,description);
        getRequestValues().diaryRepository.update(newDiary);
        getUseCaseCallback().onSuccess(null);
    }

    private void updateDiary(String title,String description){
        Diary diary = new Diary(getRequestValues().id,title,description);
        getRequestValues().diaryRepository.update(diary);
        getUseCaseCallback().onSuccess(null);
    }

    public static class RequestValues implements UseCase.RequestValues{

        private String id;
        private String title;
        private String description;
        private DiaryRepository diaryRepository;

        public RequestValues(String id, String title, String description, DiaryRepository diaryRepository) {
            this.id = id;
            this.title = title;
            this.description = description;
            this.diaryRepository = diaryRepository;
        }
    }

}
