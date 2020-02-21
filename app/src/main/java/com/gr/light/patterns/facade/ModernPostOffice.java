package com.gr.light.patterns.facade;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-20
 **/
public class ModernPostOffice {

    private Police letterPolice = new Police();

    private ILetterProcess letterProcess = new LetterProcessImpl();

    public void sendLetter(String context,String address){
        letterProcess.writeContext(context);
        letterProcess.fillEnvelope(address);
        letterPolice.checkLetter(letterProcess);
        letterProcess.letter2Envelop();
        letterProcess.sendLetter();
    }
}
