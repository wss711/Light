package com.gr.light.patterns.mediator;

import android.util.Log;

import java.util.Random;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-18
 **/
public class Sale extends AbstractColleague {

    private final static String TAG = "md";

    public Sale(AbstractMediator mediator) {
        super(mediator);
    }

    public void sellThinkpadComputer(int number){
        super.mediator.execute("sale.sell",number);
        Log.i(TAG,"销售Thinkpad电脑" + number + "台");
    }

    public int getSaleStatus(){
        Random rand = new Random(System.currentTimeMillis());
        int saleStatus = rand.nextInt(100);
        Log.i(TAG,"Thinkpad电脑的销售情况为: "+saleStatus);
        return saleStatus;
    }

    public void offSale(){
        super.mediator.execute("sale.offsell");
    }
}
