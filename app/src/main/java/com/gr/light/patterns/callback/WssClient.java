package com.gr.light.patterns.callback;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-03-25
 **/
public class WssClient implements WssCallback {

    WssService wssService = new WssService();

    public void getAnswer(){
        wssService.setCallback(this);
    }

    @Override
    public void onSuccess(String string) {
        System.out.println("得到了答案---- " + string);
    }

    @Override
    public void onError() {

    }
}
