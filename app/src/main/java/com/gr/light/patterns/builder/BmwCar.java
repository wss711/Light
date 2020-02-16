package com.gr.light.patterns.builder;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-16
 **/
public class BmwCar extends CarModel {
    @Override
    public void start() {
        System.out.println("宝马车--Start......");
    }

    @Override
    public void stop() {
        System.out.println("宝马车--Stop......");
    }

    @Override
    public void alarm() {
        System.out.println("宝马车--Alarm......");
    }

    @Override
    public void engine() {
        System.out.println("宝马车--Engine......");
    }

}
