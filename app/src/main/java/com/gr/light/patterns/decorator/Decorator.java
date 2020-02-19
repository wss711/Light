package com.gr.light.patterns.decorator;

import android.util.Log;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-19
 **/
public abstract class Decorator extends SchoolReport {
    private final static String TAG= "Decorator";
    private SchoolReport schoolReport;
    public Decorator(SchoolReport sr){
        this.schoolReport = sr;
    }
    @Override
    public void report(){
        this.schoolReport.report();
    }
    @Override
    public void sign(String name){
        this.schoolReport.sign(name);
    }
}
