package com.gr.light.patterns.compose;

import android.util.Log;

import java.util.ArrayList;

public class Client {

    private final static String TAG = "Compose";

    public static void execute(){
        Branch ceo = composeCorpTree();
        Log.i(TAG,ceo.getInfo());
        Log.i(TAG,getTreeInfo(ceo));
    }

    public static Branch composeCorpTree(){

        Branch rootCeo = new Branch("WSS","CTO",100);

        Branch developDep = new Branch("张三","研发部经理",80);
        Branch salesDep = new Branch("李四","销售部经理",60);
        Branch financeDep = new Branch("王五","财务部经理",70);

        IBranch firstDevGroup = new Branch("赵六","开发一组组长",50);
        IBranch secondDevGroup = new Branch("钱七","开发二组组长",50);

        ILeaf a = new Leaf("a","开发人员",30);
        ILeaf b = new Leaf("b","开发人员",30);
        ILeaf c = new Leaf("c","开发人员",30);
        ILeaf d = new Leaf("d","开发人员",30);
        ILeaf e = new Leaf("e","开发人员",30);
        ILeaf f = new Leaf("f","开发人员",30);
        ILeaf g = new Leaf("g","开发人员",30);
        ILeaf h = new Leaf("h","销售人员",30);
        ILeaf i = new Leaf("i","销售人员",30);
        ILeaf j = new Leaf("j","财务人员",30);
        ILeaf k = new Leaf("k","秘书",30);

        ILeaf viceDevelopDep = new Leaf("孙八","研发部副经理",70);

        // CEO
        rootCeo.addSubordinate(k);
        rootCeo.addSubordinate(developDep);
        rootCeo.addSubordinate(salesDep);
        rootCeo.addSubordinate(financeDep);

        // 研发部经理
        developDep.addSubordinate(viceDevelopDep);
        developDep.addSubordinate(firstDevGroup);
        developDep.addSubordinate(secondDevGroup);
        firstDevGroup.addSubordinate(a);
        firstDevGroup.addSubordinate(b);
        firstDevGroup.addSubordinate(c);
        secondDevGroup.addSubordinate(d);
        secondDevGroup.addSubordinate(e);
        secondDevGroup.addSubordinate(f);

        //
        salesDep.addSubordinate(h);
        salesDep.addSubordinate(i);

        //
        financeDep.addSubordinate(j);

        return rootCeo;
    }

    public static String getTreeInfo(Branch root){
        ArrayList<ICorp> subordinateList = root.getSubordinate();
        String info = "";
        for(ICorp s : subordinateList){
            if(s instanceof Leaf){
                info = info + s.getInfo() + "\n";
            }else {
                info = info + s.getInfo() + "\n" + getTreeInfo((Branch)s);
            }
        }

        return info;
    }
}
