package com.gr.light.patterns.command;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-19
 **/
public class AddRgCommand extends Command {
    @Override
    public void execute() {
        super.rg.find();
        super.rg.add();
        super.rg.plan();
    }
}
