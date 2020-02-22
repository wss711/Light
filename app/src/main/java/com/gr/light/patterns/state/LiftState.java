package com.gr.light.patterns.state;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-21
 **/
public abstract class LiftState {

    protected Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public abstract void open();
    public abstract void close();
    public abstract void run();
    public abstract void stop();
}
