package com.gr.light.patterns.chain;

import android.util.Log;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-19
 **/
public class Husband extends Handler {
    private final static String TAG = "Chain";

    public Husband(){
        super(Handler.HUSBAND_LEVEL_REQUEST);
    }

    @Override
    protected void responser(IWomen women) {
        Log.i(TAG,"------- 妻子向丈夫请示 -------");
        Log.i(TAG,women.getRequest());
        Log.i(TAG,"------- 丈夫的答复是：同意 -------");
    }
}
