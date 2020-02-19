package com.gr.light.patterns.command;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-19
 **/
public abstract class Command {
    protected RequirementGroup rg = new RequirementGroup();
    protected PageGroup pg = new PageGroup();
    protected CodeGroup cg = new CodeGroup();
    public abstract void execute();
}
