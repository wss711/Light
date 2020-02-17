package com.gr.light.patterns.proxy.normalproxy;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-17
 **/
public class ProxyNormalPatternsClient {

    public static void execute(){
        IGamePlayer proxyNormal = new GamePlayerProxy("李白");
        proxyNormal.login("libai","123654");
        proxyNormal.killBoss();
        proxyNormal.upgrade();
    }


}
