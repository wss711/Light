package com.gr.light.patterns.bridge;

import android.util.Log;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-22
 **/
public class FadeCrop extends Crop {

    private final static String TAG = "Bridge";

    public FadeCrop(Product product) {
        super(product);
    }

    public void makeMoney(){
        super.makeMoney();
        Log.i(TAG,"我得赚钱养家啊...");
    }
}
