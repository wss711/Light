package com.gr.light.patterns.interpreter;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-22
 **/
public abstract class SymbolExpression extends Expression {

    protected Expression left;
    protected Expression right;

    public SymbolExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
}
