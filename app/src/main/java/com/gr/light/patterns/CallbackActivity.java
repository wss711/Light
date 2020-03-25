package com.gr.light.patterns;

import android.os.Bundle;
import android.widget.Button;

import com.gr.light.R;
import com.gr.light.activity.BaseActivity;
import com.gr.light.patterns.callback.ClientQuestion;
import com.gr.light.patterns.callback.WssClient;

import butterknife.BindView;
import butterknife.OnClick;

public class CallbackActivity extends BaseActivity {

    @BindView(R.id.callback_test_btn)
    Button callbackTestBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_callback;
    }

    @OnClick(R.id.callback_test_btn)
    public void onClick() {
//        callbackTestBtn.setText("老师问问题");
//        Student student = new Student();
//        Teacher teacher = new Teacher(student);
//        teacher.askQuestion();

//        ClientQuestion question = new ClientQuestion();
//        question.hasQuesion();

        new WssClient().getAnswer();
    }
}
