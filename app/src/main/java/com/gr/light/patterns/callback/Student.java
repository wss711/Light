package com.gr.light.patterns.callback;

import android.util.Log;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-03-07
 **/
public class Student {

    private final String TAG = "callback";

    public void resolveQuestion(Callback callback){

        try {
            Log.i(TAG,"我在思考");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Log.i(TAG,"这是你要的答案");
        callback.tellAnswer(7);
    }
}
