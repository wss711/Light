package com.gr.light.patterns.proxy;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-16
 **/
public class GamePlayer implements IGamePlayer {
    private String name = "";
    public GamePlayer(String name){
        this.name = name;
    }

    @Override
    public void login(String user, String password) {
        System.out.println("登录名为"+ user + "的用户:" + this.name + "登录成功");
    }

    @Override
    public void killBoss() {
        System.out.println("在打Boss怪");
    }

    @Override
    public void upgrade() {
        System.out.println("恭喜 " + this.name + " 又升级了！");
    }

}
