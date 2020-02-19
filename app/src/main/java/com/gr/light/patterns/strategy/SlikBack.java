package com.gr.light.patterns.strategy;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-19
 **/
public class SlikBack {
    private IStrategy strategy;

    public SlikBack(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void operate(){
        this.strategy.operate();
    }
}
