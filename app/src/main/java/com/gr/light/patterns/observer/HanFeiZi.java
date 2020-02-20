package com.gr.light.patterns.observer;

import android.util.Log;

import java.util.ArrayList;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-20
 **/
public class HanFeiZi implements Observable,IHanFeiZi {

    private final static String TAG = "Observer";

    private ArrayList<Observer> observerList = new ArrayList<>();

    @Override
    public void haveBreakfast() {
        Log.i(TAG,"韩非子：开始吃饭了");
        this.notifyObservers("韩非子在吃饭");
    }

    @Override
    public void haveFun() {
        Log.i(TAG,"韩非子：开始娱乐了");
        this.notifyObservers("韩非子在娱乐");
    }

    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        this.observerList.remove(observer);
    }

    @Override
    public void notifyObservers(String context) {
        for(Observer observer : observerList){
            observer.update(context);
        }
    }
}
