package com.gr.light.patterns.simplefactory;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-13
 **/
public class ComputerFactory {
    public static Computer createComputer(String type) {
        Computer mComputer = null;

        switch (type) {
            case "联想":
                mComputer = new LenovoComputer();
                break;
            case "惠普":
                mComputer = new HpComputer();
                break;
            case "戴尔":
                mComputer = new DellComputer();
                break;
        }
        return mComputer;
    }
}
