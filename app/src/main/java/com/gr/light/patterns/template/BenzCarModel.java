package com.gr.light.patterns.template;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-16
 **/
public class BenzCarModel extends CarModel {

    @Override
    public void start() {
        System.out.println("奔驰启动......");
    }

    @Override
    public void stop() {
        System.out.println("奔驰停止......");
    }

    @Override
    public void alarm() {
        System.out.println("奔驰鸣笛......");
    }

    @Override
    public void engineBoom() {
        System.out.println("奔驰发动机轰鸣......");
    }

    // 默认没有喇叭
    @Override
    protected boolean isAlarm(){
        return false;
    }
}
