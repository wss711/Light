package com.gr.light.patterns.singleton;

import java.io.ObjectStreamException;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-13
 **/
public class LazyUnsafeSingleton {
    private static LazyUnsafeSingleton instance;
    private LazyUnsafeSingleton(){

    }

    public static LazyUnsafeSingleton getInstance() {
        if(instance == null){
            instance = new LazyUnsafeSingleton();
        }

        return instance;
    }

    public static void print(String string) {
        System.out.println(string);
    }

    private Object readResolve() throws ObjectStreamException{
        return instance;
    }
}
