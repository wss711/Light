package com.gr.light.patterns.mediator;

import android.util.Log;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-18
 **/
public class Stock extends AbstractColleague {

    private final static String TAG = "md";

    public Stock(AbstractMediator mediator) {
        super(mediator);
    }

    private static int COMPUTER_NUMBER = 100;

    public void increase(int number){
        COMPUTER_NUMBER = COMPUTER_NUMBER + number;
        Log.i(TAG,"库存数量增长为：" + COMPUTER_NUMBER);
    }

    public void decrease(int number){
        COMPUTER_NUMBER = COMPUTER_NUMBER - number;
        Log.i(TAG,"库存数量减少为：" + COMPUTER_NUMBER);
    }

    public int getStockNumber(){
        return COMPUTER_NUMBER;
    }

    public void clearStock(){
        Log.i(TAG,"清理存货数量为：" + COMPUTER_NUMBER);
        super.mediator.execute("stock.clear");
    }

}
