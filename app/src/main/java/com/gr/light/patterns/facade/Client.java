package com.gr.light.patterns.facade;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-20
 **/
public class Client {

    public static void execute(){
        ModernPostOffice hellPostOffice = new ModernPostOffice();
        String address = "WSS，中海锦城";
        String context = "我被病毒和愚蠢的应对憋得出不来，老天啊，您就开开眼吧";
        hellPostOffice.sendLetter(context,address);
    }

}
