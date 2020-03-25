package com.gr.light.patterns.callback;

import com.gr.light.patterns.chain.Handler;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-03-25
 **/
public class WssService {

    WssCallback wssCallback;

    public WssService() {

    }
    public void setCallback(WssCallback wssCallback){
        System.out.println(wssCallback.getClass().getName() + "设置回调成功");
        this.wssCallback = wssCallback;
        handler("给你，快拿去");
    }

    public void handler(String string){
        wssCallback.onSuccess(string);
    }
}
