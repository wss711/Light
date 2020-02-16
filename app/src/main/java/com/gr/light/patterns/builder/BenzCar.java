package com.gr.light.patterns.builder;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-16
 **/
public class BenzCar extends CarModel {
    @Override
    public void start() {
        System.out.println("奔驰车--Start......");
    }

    @Override
    public void stop() {
        System.out.println("奔驰车--Stop......");
    }

    @Override
    public void alarm() {
        System.out.println("奔驰车--Alarm......");
    }

    @Override
    public void engine() {
        System.out.println("奔驰车--Engine......");
    }

}
