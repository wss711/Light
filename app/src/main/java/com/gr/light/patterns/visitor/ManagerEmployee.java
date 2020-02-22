package com.gr.light.patterns.visitor;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-22
 **/
public class ManagerEmployee extends Employee {

    private String performance;

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
