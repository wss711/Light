package com.gr.light.patterns.compose;

public class Leaf implements ILeaf {

    private final static String TAG = "Compose";

    private String name = "";
    private String position = "";
    private int salary = 0;


    public Leaf(String name, String position, int salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String getInfo() {
        String info = "";
        info = "姓名：" + this.name;
        info = info + "\t 职位：" + this.position;
        info = info + "\t 薪水：" + this.salary;
        return info;
    }
}
