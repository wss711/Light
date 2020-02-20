package com.gr.light.patterns.observer;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-20
 **/
public interface Observable {
    void addObserver(Observer observer);
    void deleteObserver(Observer observer);
    void notifyObservers(String context);
}
