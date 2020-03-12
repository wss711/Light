package com.jr.mvp;

import android.app.Application;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-03-03
 **/
public class EnApplication extends Application {

    private static EnApplication INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
    }

    public static EnApplication getInstance(){
        return INSTANCE;
    }

}
