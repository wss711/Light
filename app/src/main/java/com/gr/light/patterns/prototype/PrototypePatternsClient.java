package com.gr.light.patterns.prototype;

import android.util.Log;

import java.util.Random;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-18
 **/
public class PrototypePatternsClient {

    private final static String TAG = "pt";

    private static  int MAX_COUNT = 6;

    public static void execute()
    {
        int i = 0;
        Mail mail = new Mail(new AdvTemplate());
        mail.setTail("招商银行版权所有");
        while(i < MAX_COUNT){
            Mail cloneMail = mail.clone();
            cloneMail.setAppllation(getRandString(5) + "先生/女士");
            cloneMail.setReceiver(getRandString(5) + "@" + getRandString(8) + ".com");
//            mail.setAppllation(getRandString(5) + "先生/女士");
//            mail.setReceiver(getRandString(5) + "@" + getRandString(8) + ".com");
            sendMail(cloneMail);
            i++;
        }
    }

    /** 发送邮件 */
    public static void sendMail(Mail mail){
        Log.i(TAG,"标题：" + mail.getSubject() + "\t收件人：" + mail.getReceiver() + "\t...发送成功！");
    }

    /** 获取指定长度的随机字符串 */
    public static String getRandString(int maxLength){
        String source = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for(int i = 0; i < maxLength; i++){
            sb.append(source.charAt(random.nextInt(source.length())));
        }

        return sb.toString();
    }
}
