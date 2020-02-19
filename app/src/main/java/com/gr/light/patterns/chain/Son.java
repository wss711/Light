package com.gr.light.patterns.chain;

import android.util.Log;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-19
 **/
public class Son extends Handler {
    private final static String TAG = "Chain";

    public Son(){
        super(Handler.SON_LEVEL_REQUEST);
    }

    @Override
    protected void responser(IWomen women) {
        Log.i(TAG,"------- 母亲向儿子请示 -------");
        Log.i(TAG,women.getRequest());
        Log.i(TAG,"------- 儿子的答复是：同意 -------");
    }
}
