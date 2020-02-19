package com.gr.light.patterns.decorator;

import android.util.Log;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-19
 **/
public class SugarFourthGradeSchoolReport extends FourthGradeSchoolReport {
    private final static String TAG = "Decorator";

    private void reportHighScore(){
        Log.i(TAG,"这次考试语文最高75，数学最高78，自然最高80");
    }

    private void reportSort(){
        Log.i(TAG,"这次考试我的排名是38名");
    }

    @Override
    public void report(){
        this.reportHighScore();
        super.report();
        this.reportSort();
    }
}
