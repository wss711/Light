package com.gr.light.patterns.bridge;

import android.util.Log;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-22
 **/
public class HouseCrop extends Crop {

    private final static String TAG = "Bridge";

    public HouseCrop(Product product) {
        super(product);
    }

    public void makeMoney(){
        super.makeMoney();
        Log.i(TAG,"房地产公司太赚钱了");
    }
}
