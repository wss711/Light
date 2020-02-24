package com.gr.mvcnote.source;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-24
 **/
public interface DataCallback<T> {
    void onSuccess(T data);
    void onError();
}
