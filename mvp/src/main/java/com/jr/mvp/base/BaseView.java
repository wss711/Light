package com.jr.mvp.base;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-03-03
 **/
public interface BaseView<T extends BasePresenter> {

    // 传入Presenter
    void setPresenter(T presenter);

}
