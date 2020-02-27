package com.gr.mvcnote.data.sourceinterface;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-24
 **/
public interface DataCallback<T> {
    // 通知成功
    void onSuccess(T data);
    // 通知错误
    void onError();
}
