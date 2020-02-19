package com.gr.light.patterns.adapter;

import android.util.Log;

import java.util.Map;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-19
 **/
public class OuterUserInfo extends OuterUser implements IUserInfo {

    private final static String TAG = "Adapter";

    private Map baseInfo = super.getUserBaseInfo();
    private Map homeInfo = super.getUserHomeInfo();
    private Map officeInfo = super.getUserOfficeInfo();

    @Override
    public String getUserName() {
        String userName = (String)this.baseInfo.get("userName");
        Log.i(TAG,userName);
        return userName;
    }

    @Override
    public String getHomeAddress() {
        String homeAddress = (String)this.homeInfo.get("homeAddress");
        Log.i(TAG,homeAddress);
        return homeAddress;
    }

    @Override
    public String getMobileNumber() {
        String mobileNumber = (String)this.baseInfo.get("mobileNumber");
        Log.i(TAG,mobileNumber);
        return mobileNumber;
    }

    @Override
    public String getOfficeTelNumber() {
        String officeTelNumber = (String)this.officeInfo.get("officeTelNumber");
        Log.i(TAG,officeTelNumber);
        return officeTelNumber;
    }

    @Override
    public String getJobPosition() {
        String jobPosition = (String)this.officeInfo.get("jobPosition");
        Log.i(TAG,jobPosition);
        return jobPosition;
    }

    @Override
    public String getHomeTelNumber() {
        String homeTelNumber = (String)this.homeInfo.get("homeTelNumber");
        Log.i(TAG,homeTelNumber);
        return homeTelNumber;
    }
}
