package com.gr.light.patterns.facade;

import android.util.Log;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-20
 **/
public class Police {

    private final static String TAG = "Facade";

    public Police() {
    }

    Police letterPolice;

    void checkLetter(ILetterProcess letterProcess) {
        Log.i(TAG,letterProcess + " 信件已经检查过了...");
    }
}
