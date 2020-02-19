package com.gr.light.patterns.mediator;

import android.util.Log;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-19
 **/
public class Client {
    private final static String TAG = "md";

    public static void execute(){
        AbstractMediator mediator = new Mediator();

        Log.i(TAG,"采购人员采购电脑");
        Purchase purchase = new Purchase(mediator);
        purchase.buyThinkpadComputer(100);

        Log.i(TAG,"销售人员销售电脑");
        Sale sale = new Sale(mediator);
        sale.sellThinkpadComputer(12);
        Log.i(TAG,"库房人员清库处理");
        Stock stock = new Stock(mediator);
        stock.clearStock();

    }

}
