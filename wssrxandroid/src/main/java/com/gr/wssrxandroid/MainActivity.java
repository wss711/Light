package com.gr.wssrxandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    TextView helloTv;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helloTv = (TextView)findViewById(R.id.rx_hello_tv);
        changeHello("抗击肺炎")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void accept(String s) throws Exception {
                        helloTv.setText(s + " ~~~~  中国   ~~~~");
                    }
                });

    }

    @SuppressLint("CheckResult")
    private Observable<String> changeHello(String s){
        return Observable.just(s);

    }

    private void updateText(String s){
        helloTv.setText(s);
    }

}
