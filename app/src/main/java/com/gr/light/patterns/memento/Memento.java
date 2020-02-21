package com.gr.light.patterns.memento;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-21
 **/
public class Memento  {

    private String state = "";

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
