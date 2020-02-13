package com.gr.light.network;

import okhttp3.Request;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-13
 **/
public abstract class ResultCallback {

    public abstract void onError(Request request,Exception e);

    public abstract void onResponse(String strUrl) throws Exception;

}
