package com.gr.mvpclean.base;

/**
 * TODO 基础View接口，给其绑定Presenter
 * <p>
 * Created by WSS on  2020-03-18
 **/
public interface BaseView< T extends BasePresenter> {
    void setPresenter(T presenter);
}
