package com.gr.light.patterns.factory;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-15
 **/
public class WhiteHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("我的皮肤是白色的");
    }

    @Override
    public void talk() {
        System.out.println("白人要说话，一般人听不懂");
    }
}
