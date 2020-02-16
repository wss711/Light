package com.gr.light.patterns.builder;

import java.util.ArrayList;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-16
 **/
public abstract class CarBuilder {
    public abstract void setSequence(ArrayList<String> sequence);
    public abstract CarModel getCarModel();
}
