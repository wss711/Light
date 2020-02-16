package com.gr.light.patterns.proxy;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-16
 **/
public class ProxyGamePlayer implements IGamePlayer {

    private IGamePlayer gamePlayer = null;

    public ProxyGamePlayer(IGamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    @Override
    public void login(String user, String password) {
        this.gamePlayer.login(user,password);
    }

    @Override
    public void killBoss() {
        this.gamePlayer.killBoss();
    }

    @Override
    public void upgrade() {
        this.gamePlayer.upgrade();
    }
}
