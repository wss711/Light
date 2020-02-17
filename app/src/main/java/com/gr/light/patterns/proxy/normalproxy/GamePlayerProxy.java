package com.gr.light.patterns.proxy.normalproxy;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-17
 **/
public class GamePlayerProxy implements IGamePlayer {

    private IGamePlayer gamePlayer = null;

    public GamePlayerProxy(String name){
        try {
            gamePlayer = new GamePlayer(this,name);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    }
}
