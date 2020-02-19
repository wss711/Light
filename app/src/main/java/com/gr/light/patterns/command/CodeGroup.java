package com.gr.light.patterns.command;

import android.util.Log;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-19
 **/
public class CodeGroup extends Group {
    private final static String TAG = "Command";
    @Override
    public void find() {
        Log.i(TAG,"找到代码组......");
    }

    @Override
    public void add() {
        Log.i(TAG,"客户要求增加一些功能......");
    }

    @Override
    public void delete() {
        Log.i(TAG,"客户要求删除一项功能......");
    }

    @Override
    public void change() {
        Log.i(TAG,"客户要求改变一些功能......");
    }

    @Override
    public void plan() {
        Log.i(TAG,"客户要求功能变更计划......");
    }
}
