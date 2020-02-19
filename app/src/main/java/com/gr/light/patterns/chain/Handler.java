package com.gr.light.patterns.chain;

import android.util.Log;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-19
 **/
public abstract class Handler {

    private final static String TAG = "Chain";

    public final static int FATHER_LEVEL_REQUEST = 1;
    public final static int HUSBAND_LEVEL_REQUEST = 2;
    public final static int SON_LEVEL_REQUEST = 3;

    private int level = 0;
    private Handler nextHandler;
    public Handler(int _level){
        this.level = _level;
    }

    public final void HandleMessage(IWomen women){
        if(women.getType() == this.level){
            this.responser(women);
        }else {
            if(this.nextHandler != null){
                this.nextHandler.HandleMessage(women);
            }else {
                Log.i(TAG,"==== 没有地方请示了，按不同意处理 ====");
            }
        }
    }

    public void setNext(Handler _handler){
        this.nextHandler = _handler;
    }

    protected abstract void responser(IWomen women);
}
