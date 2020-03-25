package com.gr.light.patterns.callback;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-03-24
 **/
public class ServiceAnswer implements Runnable {

    private String who;
    private ContactInterface callback;

    public ServiceAnswer(){

    }

    //调用此方法就表示有人联系你了，注册到你这来
    public void setCallback(String who,String question,ContactInterface callback){
        this.who = who;

        System.out.println("你(ServiceAnswer)说：当前联系到我的人是"+who+"，问题是"+question);

        this.callback = callback;
    }

    public void handlerQuestion(){
        for(int i = 0; i < 100000;i++){
            if(i == 0){
                System.out.println("你(ServiceAnswer)正在思考问题.....");
            }
        }

        String answer = "答案是两只，牛和你这个无聊的牛牛";

        // 想到问题的办法了
        System.out.println("你(ServiceAnswer)说：想到答案了，准备打回去给" + who + "告诉他答案");

        callback.callBackByTel(answer);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            handlerQuestion();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
