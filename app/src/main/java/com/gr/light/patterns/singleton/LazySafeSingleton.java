package com.gr.light.patterns.singleton;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-13
 **/
public class LazySafeSingleton {
    private static LazySafeSingleton instance;
    private LazySafeSingleton(){

    }

    public static synchronized LazySafeSingleton getInstance() {
        if(instance == null){
            instance = new LazySafeSingleton();
        }
        return instance;
    }

    public static void print(String string) {
        System.out.println(string);
    }
}
