package com.gr.light.patterns.decorator;

import android.util.Log;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-19
 **/
public class HighScoreDecorator extends Decorator {
    private final static String TAG = "Decorator";
    public HighScoreDecorator(SchoolReport sr) {
        super(sr);
    }

    private void reportHighScore(){
        Log.i(TAG,"这次考试语文最高75，数学最高78，自然最高80");
    }

    @Override
    public void report(){
        this.reportHighScore();
        super.report();
    }

}
