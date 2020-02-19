package com.gr.light.patterns.decorator;

import android.util.Log;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-19
 **/
public class FourthGradeSchoolReport extends SchoolReport {
    private final static String TAG = "Decorator";

    @Override
    public void report() {
        Log.i(TAG,"尊敬的XXX家长：");
        Log.i(TAG,"-------------------------------------");
        Log.i(TAG," 语文：62 数学：65 体育：98 自然：63");
        Log.i(TAG,"-------------------------------------");
        Log.i(TAG,"                               家长签名：_________");

    }

    @Override
    public void sign(String name) {
        Log.i(TAG,"家长签名为：" + name);
    }
}
