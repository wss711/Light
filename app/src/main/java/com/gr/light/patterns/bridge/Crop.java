package com.gr.light.patterns.bridge;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-22
 **/
public abstract class Crop {
    private Product product;

    public Crop(Product product) {
        this.product = product;
    }

    public void makeMoney(){
        this.product.beProducted();
        this.product.beSelled();
    }
}
