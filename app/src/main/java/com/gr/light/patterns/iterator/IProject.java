package com.gr.light.patterns.iterator;

public interface IProject {
    String getProjectInfo();
    void add(String name,int num,int cost);
    IProjectIterator iterator();
}
