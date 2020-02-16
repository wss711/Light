package com.gr.light.patterns.template;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-16
 **/
public class BmwCarModel extends CarModel {
    // 弄人要喇叭
    private boolean alarmFlag = true;
    @Override
    public void start() {
        System.out.println("宝马启动......");
    }

    @Override
    public void stop() {
        System.out.println("宝马停止......");
    }

    @Override
    public void alarm() {
        System.out.println("宝马鸣笛......");
    }

    @Override
    public void engineBoom() {
        System.out.println("宝马发动机轰鸣......");
    }
    @Override
    protected boolean isAlarm(){
        return this.alarmFlag;
    }

    // 客户决定要不要喇叭
    public void setAlarm(boolean isAlarm){
        this.alarmFlag = isAlarm;
    }
}
