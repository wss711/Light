package com.gr.light.patterns.command;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-19
 **/
public class DeletePgCommand extends Command {
    @Override
    public void execute() {
        super.pg.find();
        super.pg.delete();
        super.pg.plan();
    }
}
