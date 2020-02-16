package com.gr.light.patterns.builder;

import java.util.ArrayList;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-16
 **/
public abstract class CarModel {

    private ArrayList<String> sequence = new ArrayList<>();

    public abstract void start();
    public abstract void stop();
    public abstract void alarm();
    public abstract void engine();

    final public void run(){
        for (int i = 0; i < this.sequence.size(); i++){
            String actionName = this.sequence.get(i).toLowerCase();

            switch (actionName){
                case "start" :
                    this.start();
                    break;
                case "stop" :
                    this.stop();
                    break;
                case "alarm" :
                    this.alarm();
                    break;
                case "engine" :
                    this.engine();
                    break;
            }
        }
    }

    public void setSequence(ArrayList<String> sequence) {
        this.sequence = sequence;
    }

}
