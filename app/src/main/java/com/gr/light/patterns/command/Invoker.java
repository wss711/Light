package com.gr.light.patterns.command;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-19
 **/
public class Invoker {
    private Command command;
    public void setCommand(Command command){
        this.command = command;
    }

    public void action(){
        this.command.execute();
    }
}
