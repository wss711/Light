package com.gr.light.patterns.adapter;

import android.util.Log;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-19
 **/
public class UserInfo implements IUserInfo {
    private final static String TAG = "Adapter";

    @Override
    public String getUserName() {
        Log.i(TAG,"本公司员工的名字是。。。。");
        return null;
    }

    @Override
    public String getHomeAddress() {
        Log.i(TAG,"本公司员工的家庭住址是。。。。");
        return null;
    }

    @Override
    public String getMobileNumber() {
        Log.i(TAG,"本公司员工的手机号是。。。。");
        return null;
    }

    @Override
    public String getOfficeTelNumber() {
        Log.i(TAG,"本公司员工的办公室电话是。。。。");
        return null;
    }

    @Override
    public String getJobPosition() {
        Log.i(TAG,"本公司员工的工作岗位是。。。。");
        return null;
    }

    @Override
    public String getHomeTelNumber() {
        Log.i(TAG,"本公司员工的家庭电话是。。。。");
        return null;
    }
}
