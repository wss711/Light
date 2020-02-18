package com.gr.light.patterns.mediator;

import android.util.Log;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-18
 **/
public class ConcreteMediator extends AbstractMediator {

    private final static String TAG = "md";
    @Override
    public void execute(String str, Object... objects) {
        if(str.equals("purchase.buy")){
            this.b
        }
    }

    private void buyComputer(int number){
        int saleStatus = super.sale.getSaleStatus();
        if(saleStatus > 80){
            Log.i(TAG,"采购Thinkpad电脑：" + number + "台");
            super.stock.in
        }
    }
}
