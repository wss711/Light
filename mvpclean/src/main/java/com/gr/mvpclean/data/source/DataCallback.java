package com.gr.mvpclean.data.source;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-03-21
 **/
public interface DataCallback<T> {

    void onSuccess(T data);

    void onError();

}
