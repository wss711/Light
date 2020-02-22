package com.gr.light.patterns.state;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-22
 **/
public class Client {
    public static void execute(){
        Context context = new Context();
        context.setLiftState(new CloseState());
        context.open();
        context.close();
        context.run();
        context.stop();
    }
}
