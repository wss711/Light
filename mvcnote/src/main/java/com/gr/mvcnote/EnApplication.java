package com.gr.mvcnote;

import android.app.Application;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-28
 **/
public class EnApplication extends Application {

    private static EnApplication INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
    }

    public static EnApplication get(){
        return INSTANCE;
    }

}
