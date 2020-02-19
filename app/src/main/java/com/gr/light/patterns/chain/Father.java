package com.gr.light.patterns.chain;

import android.util.Log;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-19
 **/
public class Father extends Handler {
    private final static String TAG = "Chain";

    public Father(){
        super(Handler.FATHER_LEVEL_REQUEST);
    }

    @Override
    protected void responser(IWomen women) {
        Log.i(TAG,"------- 女儿向父亲请示 -------");
        Log.i(TAG,women.getRequest());
        Log.i(TAG,"------- 父亲的答复是：同意 -------");
    }
}
