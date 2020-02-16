package com.gr.light.patterns.builder;

import java.util.ArrayList;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-16
 **/
public class BenzBuilder extends CarBuilder {
    private BenzCar benzCar = new BenzCar();
    @Override
    public void setSequence(ArrayList<String> sequence) {
        this.benzCar.setSequence(sequence);
    }

    @Override
    public CarModel getCarModel() {
        return this.benzCar;
    }
}
