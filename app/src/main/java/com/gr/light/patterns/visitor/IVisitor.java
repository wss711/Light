package com.gr.light.patterns.visitor;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-22
 **/
public interface IVisitor {
    public void visit(CommonEmployee commonEmployee);
    public void visit(ManagerEmployee managerEmployee);
}
