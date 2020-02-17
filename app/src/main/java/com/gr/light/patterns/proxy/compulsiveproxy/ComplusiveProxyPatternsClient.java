package com.gr.light.patterns.proxy.compulsiveproxy;


/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-17
 **/
public class ComplusiveProxyPatternsClient {

    public static void execute(){
        GamePlayer player = new GamePlayer("杜甫");

        IGamePlayer proxyComplusive = player.getProxy();

        proxyComplusive.login("=*诗圣*=","123654");
        proxyComplusive.killBoss();
        proxyComplusive.upgrade();
    }


}
