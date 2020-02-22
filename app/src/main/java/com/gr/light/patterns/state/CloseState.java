package com.gr.light.patterns.state;

import android.util.Log;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-22
 **/
public class CloseState extends LiftState {

    private final static String TAG = "State";

    @Override
    public void open() {
        super.context.setLiftState(Context.OPEN_STATE);
        super.context.getLiftState().open();
    }

    @Override
    public void close() {
        Log.i(TAG,"电梯门关闭");
    }

    @Override
    public void run() {
        super.context.setLiftState(Context.RUN_STATE);
        super.context.getLiftState().run();
    }

    @Override
    public void stop() {
        super.context.setLiftState(Context.STOP_STATE);
        super.context.getLiftState().stop();
    }
}
