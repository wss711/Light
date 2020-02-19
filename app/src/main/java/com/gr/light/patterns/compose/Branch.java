package com.gr.light.patterns.compose;

import java.util.ArrayList;

public class Branch implements IBranch {

    private String name;
    private String position;
    private String salary;

    private ArrayList<ICorp> subordinateList = new ArrayList<>();

    public Branch(String name, String position, String salary) {
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


    @Override
    public void addSubordinate(ICorp corp) {
        this.subordinateList.add(corp);
    }

    @Override
    public ArrayList<ICorp> getSubordinate() {
        return this.subordinateList;
    }
}
