package com.gr.light.patterns.mediator;

import android.util.Log;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-18
 **/
public class Purchase extends AbstractColleague {

    private final static String TAG = "md";

    public Purchase(AbstractMediator mediator) {
        super(mediator);
    }

    // 采购Thinkpad电脑
    public void buyThinkpadComputer(int number){
        super.mediator.execute("purchase.buy",number);
    }

    //
    public void refuseBuyTkinpadComputer(){
        Log.i(TAG,"不再采购Thinpad电脑");
    }
}
