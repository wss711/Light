package com.gr.light.patterns.memento;

import android.nfc.Tag;
import android.util.Log;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-21
 **/
public class Client {

    private final static String TAG = "Memento";


    public static void execute(){
        SingleDog singleDog = new SingleDog();
        MementoManager mementoManager = new MementoManager();

        singleDog.setState("心情很棒");
        Log.i(TAG,"========= 单身狗现在的状态 ==========");
        Log.i(TAG,singleDog.getState());

        // 记下当前的状态
        mementoManager.setMemento(singleDog.createMemento());

        singleDog.changeState();
        Log.i(TAG,"========= 单身狗追女孩子后的状态 ==========");
        Log.i(TAG,singleDog.getState());

        singleDog.restoreMemento(mementoManager.getMemento());
        Log.i(TAG,"========= 单身狗回复后的状态 ==========");
        Log.i(TAG,singleDog.getState());

        singleDog.changeState();
        mementoManager.setMemento(singleDog.createMemento());
        Log.i(TAG,"========= 单身狗追女孩子后自暴自弃的状态 ==========");
        Log.i(TAG,singleDog.getState());

    }
}
