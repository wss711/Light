package com.gr.light.patterns.state;

import android.util.Log;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-22
 **/
public class RunState extends LiftState {

    private final static String TAG = "State";

    @Override
    public void open() {

    }

    @Override
    public void close() {

    }

    @Override
    public void run() {
        Log.i(TAG,"电梯上下运行");
    }

    @Override
    public void stop() {
        super.context.setLiftState(Context.STOP_STATE);
        super.context.getLiftState().stop();
    }
}
