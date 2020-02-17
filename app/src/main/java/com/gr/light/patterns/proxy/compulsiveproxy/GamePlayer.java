package com.gr.light.patterns.proxy.compulsiveproxy;


import android.util.Log;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-17
 **/
public class GamePlayer implements IGamePlayer {

    private final static String TAG = "DP";

    private String name = "";
    private IGamePlayer proxy = null;

    public GamePlayer(String name) {
        this.name = name;
    }

    @Override
    public IGamePlayer getProxy() {
        this.proxy = new ComplusGamePlayerProxy(this);
        return proxy;
    }

    @Override
    public void login(String user, String password) {
        if(isProxy()){
            Log.i(TAG,"登录名为"+ user + "的用户:" + this.name + "登录成功");
        }else {
            Log.i(TAG,"请使用指定的代理访问");
        }
    }

    @Override
    public void killBoss() {
        if(isProxy()){
            Log.i(TAG,"在打Boss怪");
        }else {
            Log.i(TAG,"请使用指定的代理访问");
        }
    }

    @Override
    public void upgrade() {
        if(isProxy()){
            Log.i(TAG,"恭喜 " + this.name + " 又升级了！");
        }else {
            Log.i(TAG,"请使用指定的代理访问");
        }
    }

    private boolean isProxy(){
        if(proxy == null){
            return false;
        }else {
            return true;
        }
    }
}
