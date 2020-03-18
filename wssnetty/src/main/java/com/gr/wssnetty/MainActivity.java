package com.gr.wssnetty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.gr.wssnetty.widget.IpEditText;

public class MainActivity extends AppCompatActivity {

    IpEditText ipEditText;
    Button joinBtn;
    TextView acceptTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ipEditText = findViewById(R.id.ip_edit_text);
        joinBtn = (Button)findViewById(R.id.join_btn);
        acceptTv = (TextView)findViewById(R.id.accept_tv);

        ipEditText.setIpEditTextListener(this);

        joinBtn.setOnClickListener(v -> {
            acceptTv.setText(ipEditText.getIpText());
        });

    }
}
