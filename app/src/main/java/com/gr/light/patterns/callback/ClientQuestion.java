package com.gr.light.patterns.callback;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-03-24
 **/
public class ClientQuestion{

    ServiceAnswer serviceAnswer = new ServiceAnswer();

    public void hasQuesion(){

        serviceAnswer.setCallback("WSS", "世界上有几只牛？", new ContactInterface() {
            @Override
            public void callBackByTel(String answer) {
                System.out.println("我(ClientQuestion)说：嗯，好的，我收到答案了:"+answer+"，谢谢");
            }
        });

        new Thread(serviceAnswer).start();

    }

}
