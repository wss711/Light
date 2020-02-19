package com.gr.light.patterns.chain;

import java.util.ArrayList;
import java.util.Random;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-19
 **/
public class Client {
    public static void execute(){
        Random random = new Random();
        ArrayList<IWomen> arrayList = new ArrayList<>();

        for(int i = 0; i < 5; i++){
            arrayList.add(new Women(random.nextInt(4),"我要出去打麻将"));
        }

        Handler fatherHandler = new Father();
        Handler husbandHandler = new Husband();
        Handler sonHandler = new Son();
        fatherHandler.setNext(husbandHandler);
        husbandHandler.setNext(sonHandler);

        for(IWomen women : arrayList){
            fatherHandler.HandleMessage(women);
        }


    }

}
