package com.gr.light.patterns.iterator;

import android.util.Log;

public class Client {
    private final static String TAG = "Iterator";

    public static void execute(){
        IProject project = new Project();

        project.add("星球大战项目",10,1000000);
        project.add("超人改造项目",100,1000);
        project.add("拍苍蝇项目",10000,100);
        for(int i = 4; i < 104; i++){
            project.add("第" + i + "个项目",i*5, i*100);
        }

        IProjectIterator projectIterator = project.iterator();

        while (projectIterator.hasNext()){
            IProject p = (IProject) projectIterator.next();
            Log.i(TAG,p.getProjectInfo());
        }
    }
}
