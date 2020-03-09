package com.gr.light.patterns.callback;

import android.util.Log;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-03-07
 **/
public class Teacher implements Callback {

    private final String TAG = "callback";

    private Student student;

    public Teacher(Student student){
        this.student = student;
    }

    public void askQuestion(){
        Log.i(TAG,"我要问问题了，请在3秒钟后给我答案");
        student.resolveQuestion(this);
    }

    @Override
    public void tellAnswer(int answer) {
        Log.i(TAG,"知道了，你的答案是" + answer);
    }
}
