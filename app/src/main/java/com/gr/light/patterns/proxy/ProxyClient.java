package com.gr.light.patterns.proxy;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-16
 **/
public class ProxyClient {
    public static void execute(){
        IGamePlayer player = new GamePlayer("Wss");
        IGamePlayer proxyPlayer = new ProxyGamePlayer(player);
        proxyPlayer.login("wss","123654");
        proxyPlayer.killBoss();
        proxyPlayer.upgrade();
        //
    }
}
