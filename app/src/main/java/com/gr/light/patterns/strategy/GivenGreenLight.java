package com.gr.light.patterns.strategy;

import android.util.Log;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-19
 **/
public class GivenGreenLight implements IStrategy {

    private final static String TAG = "Strategy";

    @Override
    public void operate() {
        Log.i(TAG,"求吴国太开绿灯，放行！");
    }
}
