package com.gr.light.patterns.singleton;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-13
 **/
public class dclSingleton {
    private volatile static dclSingleton instance;
    private dclSingleton(){

    }

    public static dclSingleton getInstance() {
        if(instance == null){
            synchronized (dclSingleton.class){
                if(instance == null){
                    instance = new dclSingleton();
                }
            }
        }

        return instance;
    }

    public static void print(String string) {
        System.out.println(string);
    }
}
