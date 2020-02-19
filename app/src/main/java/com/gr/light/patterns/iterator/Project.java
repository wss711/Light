package com.gr.light.patterns.iterator;

import android.nfc.Tag;
import android.util.Log;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class Project implements IProject {

    private final static String TAG = "Iterator";

    private ArrayList<IProject> projectList = new ArrayList<>();

    private String name;
    private int num;
    private int cost;

    public Project() {

    }

    private Project(String name, int num, int cost) {
        this.name = name;
        this.num = num;
        this.cost = cost;
    }

    @Override
    public String getProjectInfo() {
        String info ="";
        info = info + "***项目的名称是：" + name + "-----";
        info = info + "***项目的人数是：" + num+ "-----";
        info = info + "***项目的费用是：" + cost+ "-----";
        return info;
    }

    @Override
    public void add(String name, int num, int cost) {
        this.projectList.add(new Project(name,num,cost));
    }

    @Override
    public IProjectIterator iterator() {

        return new ProjectIterator(projectList);
    }
}
