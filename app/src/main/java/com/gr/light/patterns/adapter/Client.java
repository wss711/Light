package com.gr.light.patterns.adapter;

import android.util.Log;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-19
 **/
public class Client {
    private final static String TAG = "Adapter";
    public static void execute(){

        Log.i(TAG,"======= 本公司职员的电话 ========");
        IUserInfo selfStaff = new UserInfo();
        for(int i = 0; i < 11; i++){
            selfStaff.getMobileNumber();
        }
        Log.i(TAG,"=======  外包公司职员的电话 ========");
        IUserInfo outerStaff = new OuterUserInfo();
        for(int i = 0; i < 11; i++){
            outerStaff.getMobileNumber();
        }

    }
}
