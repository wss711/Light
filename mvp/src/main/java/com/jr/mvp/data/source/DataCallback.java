package com.jr.mvp.data.source;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-03-03
 **/
public interface DataCallback<T> {

    void onSuccess(T data);

    void onError();
}
