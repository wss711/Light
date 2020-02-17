package com.gr.light.patterns.proxy.compulsiveproxy;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-17
 **/
public interface IGamePlayer {

    IGamePlayer getProxy();

    void login(String user,String password);
    void killBoss();
    void upgrade();


}
