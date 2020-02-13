package com.gr.light.patterns.singleton;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-13
 **/
public class HungrySingleton {

     private static HungrySingleton instance = new HungrySingleton();

     private HungrySingleton(){
     }

    public static HungrySingleton getInstance() {
        return instance;
    }

    public static void print(String string){
        System.out.println(string);
    }


}
