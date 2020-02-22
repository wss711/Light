package com.gr.light.patterns.interpreter;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-22
 **/
public class Client {

    private final static String TAG = "Interpreter";

    public static void execute()  {

        String expStr = "a+b-c";
        HashMap<String,Integer> var = getValue(expStr);
        Calculator cal = new Calculator(expStr);

        System.out.println("运算结果为："+ expStr + "=" + cal.run(var));
    }


    public static HashMap<String,Integer> getValue(String expStr) {
        HashMap<String,Integer> map = new HashMap<>();
        for(char ch:expStr.toCharArray()){
            if(ch != '+' && ch != '-'){
                if(!map.containsKey(String.valueOf(ch))){
                    map.put(String.valueOf(ch),Integer.valueOf(100));
                }
            }
        }
        return map;
    }
}
