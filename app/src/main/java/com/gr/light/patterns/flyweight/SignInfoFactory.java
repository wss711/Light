package com.gr.light.patterns.flyweight;

import android.util.Log;

import java.util.HashMap;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-22
 **/
public class SignInfoFactory {

    private final static String TAG = "Flyweight";

    private static HashMap<String,SignInfo> pool = new HashMap<>();

    public static SignInfo getSignInfo(String key){

        SignInfo result = null;
        if(!pool.containsKey(key)){
            Log.i(TAG,key + "---- 建立对象，并放置到吃2中");
            result = new SignInfo4Pool(key);
            pool.put(key,result);
        }else {
            result = pool.get(key);
            Log.i(TAG,key + "---- 直接从池中取得");
        }
        return result;
    }
}
