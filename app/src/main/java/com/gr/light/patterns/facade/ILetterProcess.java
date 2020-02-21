package com.gr.light.patterns.facade;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-20
 **/
public interface ILetterProcess {
    void writeContext(String context);
    void fillEnvelope(String address);
    void letter2Envelop();
    void sendLetter();
}
