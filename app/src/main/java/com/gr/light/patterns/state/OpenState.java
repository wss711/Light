package com.gr.light.patterns.state;

import android.util.Log;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-22
 **/
public class OpenState extends LiftState {

    private final static String TAG = "State";

    @Override
    public void open() {
        Log.i(TAG,"电梯门开启");
    }

    @Override
    public void close() {
        super.context.setLiftState(Context.CLOSE_STATE);
        super.context.getLiftState().close();
    }

    @Override
    public void run() {

    }

    @Override
    public void stop() {

    }
}
