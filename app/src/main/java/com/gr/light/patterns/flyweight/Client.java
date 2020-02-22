package com.gr.light.patterns.flyweight;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-22
 **/
public class Client {
    public static void execute(){
        for(int i = 0; i < 4; i++){
            String suject = "科目" + i;

            for(int j = 0; j < 30; j++){
                String key = suject + "考试地点" + j;
                SignInfoFactory.getSignInfo(key);
            }
        }

        SignInfo signInfo = SignInfoFactory.getSignInfo("科目1考试地点1");

    }
}
