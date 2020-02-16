package com.gr.light.patterns.builder;

import java.util.ArrayList;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-16
 **/
public class BmwBuilder extends CarBuilder {
    private BmwCar bmwCar = new BmwCar();
    @Override
    public void setSequence(ArrayList<String> sequence) {
        this.bmwCar.setSequence(sequence);
    }

    @Override
    public CarModel getCarModel() {
        return this.bmwCar;
    }
}
