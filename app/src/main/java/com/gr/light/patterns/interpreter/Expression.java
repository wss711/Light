package com.gr.light.patterns.interpreter;

import java.util.HashMap;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-22
 **/
public abstract class Expression {
    public abstract int interpreter(HashMap<String,Integer> var);
}
