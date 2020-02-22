package com.gr.light.patterns.interpreter;

import java.util.HashMap;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-22
 **/
public class VarExpression extends Expression {

    private String key;

    public VarExpression(String key) {
        this.key = key;
    }

    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return var.get(this.key);
    }
}
