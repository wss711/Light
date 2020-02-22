package com.gr.light.patterns.interpreter;

import java.util.HashMap;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-22
 **/
public class SubExpression extends SymbolExpression {

    public SubExpression(Expression _left, Expression _right){
        super(_left,_right);
    }

    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return super.left.interpreter(var) - super.right.interpreter(var);
    }
}
