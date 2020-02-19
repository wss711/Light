package com.gr.light.patterns.decorator;

import android.util.Log;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-19
 **/
public class SortDecorator extends Decorator {

    private final static String TAG = "Decorator";

    public SortDecorator(SchoolReport sr) {
        super(sr);
    }

    private void reportSort(){
        Log.i(TAG,"这次考试我的排名是38名");
    }
    @Override
    public void report(){
        super.report();
        this.reportSort();
    }
}
