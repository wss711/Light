package com.gr.light.patterns.observer;

import android.util.Log;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-20
 **/
public class WangSi implements Observer {

    private final String TAG = "Observer";

    @Override
    public void update(String context) {
        Log.i(TAG,"王斯：观察到韩非子的活动，开始向老板汇报了");
        this.report2Qinshihuang(context);
        Log.i(TAG,"王斯：汇报完毕...\n");
    }

    private void report2Qinshihuang(String reportContext){
        Log.i(TAG,"王斯：报告，秦老板！ 韩非子有行动了 -->" + reportContext);
    }
}
