package com.gr.light.patterns.bridge;

import android.util.Log;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-22
 **/
public class Client {

    private final static String TAG = "Bridge";

    public static void execute(){
        House house = new House();
        Log.i(TAG,"--------------- 房地产公司是这样赚钱的 -----------------");
        HouseCrop houseCrop = new HouseCrop(house);
        houseCrop.makeMoney();

        Log.i(TAG,"--------------- 山寨公司是这样赚钱的 -----------------");
        FadeCrop fadeCrop = new FadeCrop(new Ipod());
        fadeCrop.makeMoney();

        FadeCrop fadeCrop1 = new FadeCrop(new Clothes());
        fadeCrop1.makeMoney();

    }
}
