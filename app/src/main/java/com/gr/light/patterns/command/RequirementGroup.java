package com.gr.light.patterns.command;

import android.util.Log;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-19
 **/
public class RequirementGroup extends Group {
    private final static String TAG = "Command";
    @Override
    public void find() {
        Log.i(TAG,"找到需求组......");
    }

    @Override
    public void add() {
        Log.i(TAG,"客户要求增加一些需求......");
    }

    @Override
    public void delete() {
        Log.i(TAG,"客户要求删除一项需求......");
    }

    @Override
    public void change() {
        Log.i(TAG,"客户要求改变一些需求......");
    }

    @Override
    public void plan() {
        Log.i(TAG,"客户要求需求变更计划......");
    }
}
