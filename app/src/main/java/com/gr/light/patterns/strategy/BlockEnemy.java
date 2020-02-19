package com.gr.light.patterns.strategy;

import android.util.Log;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-19
 **/
public class BlockEnemy implements IStrategy {

    private final static String TAG = "Strategy";

    @Override
    public void operate() {
        Log.i(TAG,"孙夫人断后，挡住追兵");
    }
}
