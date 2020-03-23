package com.gr.mvpclean.contract;

import androidx.annotation.NonNull;

import com.gr.mvpclean.activity.fragment.adapter.DiaryAdapter;
import com.gr.mvpclean.base.BasePresenter;
import com.gr.mvpclean.base.BaseView;
import com.gr.mvpclean.model.Diary;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-03-22
 **/
public interface DiaryContract {

    /** 日记列表视图 */
    interface View extends BaseView<Presenter>{

        void gotoWriteDiary();

        void gotoUpdateDiary(String diaryId);

        void showSuccess();

        void showError();

        boolean isActive();

        void setAdapter(DiaryAdapter diaryAdapter);
    }

    /** 日记列表主持人 */
    interface Presenter extends BasePresenter{

        void loadDiary();

        void addDiary();

        void updateDiary(@NonNull Diary diary);

        void onResult(int requestCode,int reponseCode);

    }
}
