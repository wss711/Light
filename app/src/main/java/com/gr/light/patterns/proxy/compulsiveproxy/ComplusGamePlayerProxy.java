package com.gr.light.patterns.proxy.compulsiveproxy;

import android.util.Log;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-17
 **/
public class ComplusGamePlayerProxy implements IGamePlayer,IUpgrade{

    private final static String TAG = "DP";

    private IGamePlayer gamePlayer = null;

    public ComplusGamePlayerProxy(IGamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
    }


    @Override
    public IGamePlayer getProxy() {
        return this;
    }

    @Override
    public void login(String user, String password) {
        gamePlayer.login(user,password);
    }

    @Override
    public void killBoss() {
        gamePlayer.killBoss();
    }

    @Override
    public void upgrade() {
        gamePlayer.upgrade();
        count();
    }

    @Override
    public void count() {
        Log.i(TAG,"升级总费用是：人民币200元");
    }
}
