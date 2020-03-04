package com.jr.mvp.main;

import androidx.annotation.NonNull;

import com.jr.mvp.base.BasePresenter;
import com.jr.mvp.base.BaseView;
import com.jr.mvp.main.list.DiaryAdapter;
import com.jr.mvp.model.Diary;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-03-03
 **/
public interface DiaryContract {

    interface View extends BaseView<Presenter>{

        void gotoWriteDiary();

        void gotoUpdateDiary();

        void showSuccess();

        void showError();

        boolean isActive();

        void setListAdapter(DiaryAdapter mListAdapter);

    }

    interface Presenter extends BasePresenter{

        void loadDiary();

        void addDiary();

        void updateDiary(@NonNull Diary diary);

        void onResult(int requestCode,int resultCode);
        
    }

}
