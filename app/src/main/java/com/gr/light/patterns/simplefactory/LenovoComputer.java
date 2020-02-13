package com.gr.light.patterns.simplefactory;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-13
 **/
public class LenovoComputer implements Computer {
    @Override
    public void start() {
        System.out.println("联想计算机启动");
    }
}
