package com.gr.light.patterns.command;

import android.util.Log;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-19
 **/
public class Client {
    private final static String TAG = "Command";
    public static void execute(){
        Invoker invoker = new Invoker();
        Log.i(TAG,"客户要求增加一项需求");
        Command command = new AddRgCommand();
        invoker.setCommand(command);
        invoker.action();
    }

}
