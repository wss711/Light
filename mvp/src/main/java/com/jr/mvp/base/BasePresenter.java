package com.jr.mvp.base;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-03-03
 **/
public interface BasePresenter {

    // Presenter 生命周期的开始
    void subscribe();

    // Presenter 生命周期的结束
    void unSubscribe();
}
