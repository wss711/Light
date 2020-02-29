package com.gr.activemvcnote.data;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-29
 **/
public interface DataCallback<T> {

    void onSuccess( T data);

    void onError();
}
