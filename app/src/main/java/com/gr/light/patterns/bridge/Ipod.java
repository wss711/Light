package com.gr.light.patterns.bridge;

import android.util.Log;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-22
 **/
public class Ipod extends Product {

    private final static String TAG = "Bridge";

    @Override
    public void beProducted() {
        Log.i(TAG,"生产出来的Ipod是这样的...");
    }

    @Override
    public void beSelled() {
        Log.i(TAG,"生产出来的Ipod被卖出去了...");
    }
}
