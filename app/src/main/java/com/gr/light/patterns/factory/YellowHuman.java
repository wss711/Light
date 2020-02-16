package com.gr.light.patterns.factory;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-15
 **/
public class YellowHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("我的皮肤是黄色的");
    }

    @Override
    public void talk() {
        System.out.println("黄人要说话，一般人听不懂");
    }
}
