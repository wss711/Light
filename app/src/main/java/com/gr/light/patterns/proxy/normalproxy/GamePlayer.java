package com.gr.light.patterns.proxy.normalproxy;

import android.util.Log;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-17
 **/
public class GamePlayer implements IGamePlayer {

    private final static String TAG = "DP";

    private String name = "";

    // 限制谁能创造对象
    public GamePlayer(IGamePlayer _gamePlayer,String _name) throws Exception{
        if (_gamePlayer == null){
            throw new Exception("不能得到真实的角色");
        }else{
            this.name = _name;
        }
    }

    @Override
    public void login(String user, String password) {
        Log.i(TAG,"登录名为"+ user + "的用户:" + this.name + "登录成功");
    }

    @Override
    public void killBoss() {
        Log.i(TAG,"在打Boss怪");
    }

    @Override
    public void upgrade() {
        Log.i(TAG,"恭喜 " + this.name + " 又升级了！");
    }
}
