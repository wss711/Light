package com.gr.light.patterns.facade;

import android.util.Log;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-20
 **/
public class LetterProcessImpl implements ILetterProcess {

    private final static String TAG = "Facade";

    @Override
    public void writeContext(String context) {
        Log.i(TAG,"填写信的内容..." + context);
    }

    @Override
    public void fillEnvelope(String address) {
        Log.i(TAG,"填写收件人地址及姓名..." + address);
    }

    @Override
    public void letter2Envelop() {
        Log.i(TAG,"将信放到信封中...");
    }

    @Override
    public void sendLetter() {
        Log.i(TAG,"邮寄信件...");
    }
}
