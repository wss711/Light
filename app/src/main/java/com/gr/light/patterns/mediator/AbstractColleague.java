package com.gr.light.patterns.mediator;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-18
 **/
public class AbstractColleague {
    protected AbstractMediator mediator;

    public AbstractColleague(AbstractMediator mediator) {
        this.mediator = mediator;
    }
}
