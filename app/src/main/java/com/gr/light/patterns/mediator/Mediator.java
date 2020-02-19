package com.gr.light.patterns.mediator;

import android.util.Log;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-18
 **/
public class Mediator extends AbstractMediator {

    private final static String TAG = "md";
    @Override
    public void execute(String str, Object... objects) {
        if(str.equals("purchase.buy")){
            this.buyComputer((Integer)objects[0]);
        }else if(str.equals("sale.sell")){
            this.sellComputer((Integer)objects[0]);
        }else if(str.equals("sale.offsell")){
            this.offSell();
        }else if(str.equals("stock.clear")){
            this.clearStock();
        }
    }

    private void buyComputer(int number){
        int saleStatus = super.sale.getSaleStatus();
        if(saleStatus > 80){
            Log.i(TAG,"采购Thinkpad电脑：" + number + "台");
            super.stock.increase(number);
        }else {
            int buyNumber = number /2 ;
            Log.i(TAG,"采购Thinkpad电脑：" + number + "台");
        }
    }

    private void sellComputer(int number){
        if(super.stock.getStockNumber() < number){
            super.purchase.buyThinkpadComputer(number);
        }
        super.stock.decrease(number);
    }

    private void offSell(){
        Log.i(TAG,"折价销售Thinkpad电脑：" + stock.getStockNumber() + "台");
    }

    private void clearStock(){
        super.sale.offSale();
        super.purchase.refuseBuyTkinpadComputer();
    }
}
