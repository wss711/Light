package com.jr.mvp.edit;

import com.jr.mvp.base.BasePresenter;
import com.jr.mvp.base.BaseView;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-03-05
 **/
public interface DiaryEditContract {

    interface View extends BaseView<Presenter>{

        void showError();

        void showDiaryList();

        void setTitle(String title);

        void setDescription(String description);

        boolean isActive();

    }

    interface Presenter extends BasePresenter{

        void saveDiary(String title,String description);

        void requestDiary();
    }
}
