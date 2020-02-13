package com.gr.light.patterns.singleton;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-13
 **/
public class InnerClassSingleton {
    private InnerClassSingleton(){

    }

    private static class SingletonHolder{
        private static final InnerClassSingleton instance = new InnerClassSingleton();
    }

    public static InnerClassSingleton getInstance(){
        return SingletonHolder.instance;
    }

    public static void print(String string) {
        System.out.println(string);
    }
}
