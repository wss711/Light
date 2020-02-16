package com.gr.light.patterns.template;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-16
 **/
public abstract class CarModel {
    // 抽象方法
    public abstract void start();
    public abstract void stop();
    public abstract void alarm();
    public abstract void engineBoom();

    // 具体方法
    final public void run(){
        this.start();
        this.engineBoom();
        if(this.isAlarm()){
            this.alarm();
        }
        this.stop();
    }

    // 钩子方法
    protected boolean isAlarm(){
        return true;
    }
}
