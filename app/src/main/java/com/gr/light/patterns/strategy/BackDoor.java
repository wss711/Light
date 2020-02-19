package com.gr.light.patterns.strategy;

import android.util.Log;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-19
 **/
public class BackDoor implements IStrategy {

    private final static String TAG = "Strategy";

    @Override
    public void operate() {
        Log.i(TAG,"找乔国老帮忙，让吴国太给孙权施加压力");
    }
}
