package com.gr.mvpclean.utils;

import android.os.Handler;
import android.os.Looper;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-03-21
 **/
public final class ThreadUtils {

    public static void runOnUI(Runnable runnable){
        if(runnable == null){
            return;
        }
        if(Looper.myLooper() != Looper.getMainLooper()){
            new Handler(Looper.getMainLooper()).post(runnable);
        }else{
            runnable.run();
        }
    }
}
