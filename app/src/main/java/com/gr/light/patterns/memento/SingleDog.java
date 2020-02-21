package com.gr.light.patterns.memento;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-21
 **/
public class SingleDog {
    private String state = "";

    public void changeState(){
        this.state = "心情可能很不好";
    }

    public String getState(){
        return state;
    }

    public void setState(String state){
        this.state = state;
    }

    //
    public Memento createMemento(){
        return new Memento(this.state);
    }

    public void restoreMemento(Memento _memento){
        this.setState(_memento.getState());
    }
}
