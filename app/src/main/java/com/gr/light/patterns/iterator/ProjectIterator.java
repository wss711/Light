package com.gr.light.patterns.iterator;

import android.net.IpPrefix;

import java.util.ArrayList;

public class ProjectIterator implements IProjectIterator {

    private ArrayList<IProject> projectList = new ArrayList<IProject>();
    private int currentItem =0;

    public ProjectIterator(ArrayList<IProject> projectList) {
        this.projectList = projectList;
    }

    @Override
    public boolean hasNext() {
        boolean b = true;
        if(currentItem >= projectList.size() || projectList.get(currentItem) == null){
            b = false;
        }
        return b;
    }

    @Override
    public Object next() {
        return (IProject)projectList.get(currentItem++);
    }

    @Override
    public void remove() {

    }
}
