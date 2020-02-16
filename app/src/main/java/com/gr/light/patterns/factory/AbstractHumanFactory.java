package com.gr.light.patterns.factory;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-15
 **/
public abstract class AbstractHumanFactory {
    public abstract <T extends Human> T createHuman( Class<T> c);
}
