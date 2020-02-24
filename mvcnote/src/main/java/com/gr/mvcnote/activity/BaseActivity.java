package com.gr.mvcnote.activity;

import android.app.Activity;
import android.os.Bundle;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-24
 **/
public abstract class BaseActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initVariables();
        initViews(savedInstanceState);
        loadData();

    }

    protected abstract void initVariables();
    protected abstract void initViews(Bundle savedInstanceState);
    protected abstract void loadData();

}
