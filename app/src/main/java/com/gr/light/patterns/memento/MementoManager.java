package com.gr.light.patterns.memento;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-21
 **/
public class MementoManager {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
