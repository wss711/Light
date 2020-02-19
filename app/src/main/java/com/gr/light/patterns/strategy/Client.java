package com.gr.light.patterns.strategy;

import android.util.Log;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-19
 **/
public class Client {
    private final static String TAG = "Strategy";

    public static void execute(){
        SlikBack slikBack;

        Log.i(TAG,"----- 刚刚到吴国的时候，打开第一个锦囊 -----");
        slikBack = new SlikBack(new BackDoor());
        slikBack.operate();
        Log.i(TAG,"----- 刘备乐不思蜀了，打开第二个锦囊 -----");
        slikBack = new SlikBack(new GivenGreenLight());
        slikBack.operate();
        Log.i(TAG,"----- 孙权的兵追来的时候，打开第三个锦囊 -----");
        slikBack = new SlikBack(new BlockEnemy());
        slikBack.operate();
    }

}
