package com.gr.wssnetty.widget;


import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.gr.wssnetty.R;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-03-16
 **/
public class IpEditText extends LinearLayout {

    private EditText firstIpEt;
    private EditText secondIpEt;
    private EditText thirdIpEt;
    private EditText fourthIpEt;

    private String firstIp;
    private String secondIp;
    private String thirdIp;
    private String fourthIp;

    public IpEditText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.ip_edit_layout,this);

        firstIpEt = (EditText)findViewById(R.id.first_ip_et);
        secondIpEt = (EditText)findViewById(R.id.second_ip_et);
        thirdIpEt = (EditText)findViewById(R.id.third_ip_et);
        fourthIpEt = (EditText)findViewById(R.id.fourth_ip_et);
    }

    public void setIpEditTextListener(final Context context){
        //  设置第1个IP字段的事件监听
        firstIpEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().trim().equals(".")){
                    firstIp = "";
                    return;
                }

                if(s.length()>2 || s.toString().trim().contains(".")){

                    if(s.toString().trim().contains(".")){
                        firstIp = s.toString().trim().substring(0,s.length() - 1);
                    } else {
                        firstIp = s.toString().trim();
                    }

                    if(Integer.parseInt(firstIp) > 255){
                        firstIp = "255";
                    }

                    secondIpEt.setFocusable(true);
                    secondIpEt.requestFocus();
                }else {
                    firstIp = s.toString().trim();
                }
            }


            @Override
            public void afterTextChanged(Editable s) {
                firstIpEt.removeTextChangedListener(this);
                firstIpEt.setText(firstIp);
                firstIpEt.setSelection(firstIpEt.length());
                firstIpEt.addTextChangedListener(this);
            }
        });
        //  设置第2个IP字段的事件监听
        secondIpEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // 长度为0，返回到上一个文本编辑框
                if(s.toString().length() == 0){
                    firstIpEt.setFocusable(true);
                    firstIpEt.requestFocus();
                }
                if(s.toString().trim().equals(".")){
                    secondIp = "";
                    return;
                }

                if(s.length() > 2 || s.toString().trim().contains(".")){
                    if(s.toString().trim().contains(".")){
                        secondIp = s.toString().trim().substring(0,s.length() - 1);
                    }else{
                        secondIp = s.toString().trim();
                    }

                    if(Integer.parseInt(secondIp) > 255){
                        secondIp = "255";
                    }
                    thirdIpEt.setFocusable(true);
                    thirdIpEt.requestFocus();
                }else{
                    secondIp = s.toString().trim();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                secondIpEt.removeTextChangedListener(this);
                secondIpEt.setText(secondIp);
                secondIpEt.setSelection(secondIp.length() );
                secondIpEt.addTextChangedListener(this);
            }
        });
        //  设置第3个IP字段的事件监听
        thirdIpEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().length() == 0){
                    secondIpEt.setFocusable(true);
                    secondIpEt.requestFocus();
                }

                if(s.toString().trim().equals(".")){
                    thirdIp = "";
                    return;
                }

                if(s.length() > 2 || s.toString().trim().contains(".")){
                    if(s.toString().trim().contains(".")){
                        thirdIp = s.toString().trim().substring(0,s.length() - 1);
                    }else{
                        thirdIp = s.toString().trim();
                    }
                    if(Integer.parseInt(thirdIp) > 255){
                        thirdIp = "255";
                    }
                    fourthIpEt.setFocusable(true);
                    fourthIpEt.requestFocus();
                }else{
                    thirdIp = s.toString().trim();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                thirdIpEt.removeTextChangedListener(this);
                thirdIpEt.setText(thirdIp);
                thirdIpEt.setSelection(thirdIp.length());
                thirdIpEt.addTextChangedListener(this);
            }
        });
        //  设置第4个IP字段的事件监听
        fourthIpEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().length() == 0){
                    thirdIpEt.setFocusable(true);
                    thirdIpEt.requestFocus();
                }
                if(s.toString().trim().equals(".")){
                    fourthIp = "";
                    return;
                }
                if(s.length() > 2 || s.toString().trim().contains(".")){
                    if(s.toString().trim().contains(".")){
                        fourthIp = s.toString().trim().substring(0, s.length() - 1);
                    }else {
                        fourthIp = s.toString().trim();
                    }
                    if(Integer.parseInt(fourthIp) > 255){
                        fourthIp = "255";
                    }
                }else {
                    fourthIp = s.toString().trim();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                fourthIpEt.removeTextChangedListener(this);
                fourthIpEt.setText(fourthIp);
                fourthIpEt.setSelection(fourthIp.length());
                fourthIpEt.addTextChangedListener(this);
            }
        });
    }

    /**
     * TODO  返回整个IP地址
     *
     * @param
     * @return
     * @author WSS
     * @time 2020-03-16 15:53
     **/
    public String getIpText(){
        if(TextUtils.isEmpty(firstIp) || TextUtils.isEmpty(secondIp)
                || TextUtils.isEmpty(thirdIp) || TextUtils.isEmpty(fourthIp)){
            return null;
        }
        return firstIp + "." + secondIp + "." + thirdIp + "." + fourthIp;
    }

    /**
     * TODO 本地读取的ip地址显示在IP控件
     *
     * @param
     * @return
     * @author WSS
     * @time 2020-03-16 15:56
     **/
    public void setIpText(String ipText){
        if(TextUtils.isEmpty(ipText) || ipText == null){
            return;
        }

        String[] tmp = null;
        tmp = ipText.split("\\.");
        if(tmp != null){
            firstIpEt.setText(tmp[0]);
            secondIpEt.setText(tmp[1]);
            thirdIpEt.setText(tmp[2]);
            fourthIpEt.setText(tmp[3]);
        }
    }
}
