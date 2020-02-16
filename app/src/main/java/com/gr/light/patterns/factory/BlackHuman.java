package com.gr.light.patterns.factory;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-15
 **/
public class BlackHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("我的皮肤是黑色的");
    }

    @Override
    public void talk() {
        System.out.println("黑人要说话，一般人听不懂");
    }
}
