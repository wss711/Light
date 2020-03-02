package com.gr.activemvcnote.observer;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-03-02
 **/
public interface Observer<T> {
    void update(T data);
}
