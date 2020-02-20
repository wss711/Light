package com.gr.light.patterns.observer;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-20
 **/
public class Client {
    public static void execute(){
        Observer liSi = new LiSi();
        Observer WangSi = new WangSi();
        Observer chenSi = new ChenSi();

        HanFeiZi hanFeiZi = new HanFeiZi();
        hanFeiZi.addObserver(liSi);
        hanFeiZi.addObserver(WangSi);
        hanFeiZi.addObserver(chenSi);

        hanFeiZi.haveBreakfast();
    }
}
