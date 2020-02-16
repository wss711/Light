package com.gr.light.patterns.builder;

import java.util.ArrayList;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-16
 **/
public class Director {
    private ArrayList<String> sequence = new ArrayList<>();
    private BmwBuilder bmwBuilder = new BmwBuilder();
    private BenzBuilder benzBuilder = new BenzBuilder();

    public BmwCar getBmwX1(){
        this.sequence.clear();
        this.sequence.add("start");
        this.sequence.add("alarm");

        bmwBuilder.setSequence(this.sequence);
        return (BmwCar)bmwBuilder.getCarModel();
    }

    public BmwCar getBmwX3(){
        this.sequence.clear();
        this.sequence.add("alarm");
        this.sequence.add("start");
        this.sequence.add("engine");

        bmwBuilder.setSequence(this.sequence);
        return (BmwCar)bmwBuilder.getCarModel();
    }

    public BmwCar getBmwX5(){
        this.sequence.clear();
        this.sequence.add("start");
        this.sequence.add("alarm");
        this.sequence.add("engine");
        this.sequence.add("stop");

        bmwBuilder.setSequence(this.sequence);
        return (BmwCar)bmwBuilder.getCarModel();
    }

    public BenzCar getBenzGlc(){
        this.sequence.clear();
        this.sequence.add("start");
        this.sequence.add("alarm");

        benzBuilder.setSequence(this.sequence);
        return (BenzCar) benzBuilder.getCarModel();
    }

    public BenzCar getBenzGle(){
        this.sequence.clear();
        this.sequence.add("start");
        this.sequence.add("alarm");
        this.sequence.add("engine");

        benzBuilder.setSequence(this.sequence);
        return (BenzCar) benzBuilder.getCarModel();
    }

    public BenzCar getBenzGls(){
        this.sequence.clear();
        this.sequence.clear();
        this.sequence.add("start");
        this.sequence.add("alarm");
        this.sequence.add("engine");
        this.sequence.add("stop");

        benzBuilder.setSequence(this.sequence);
        return (BenzCar) benzBuilder.getCarModel();
    }




}
