package com.gr.light.patterns.visitor;

import android.util.Log;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-22
 **/
public class Visitor implements IVisitor {

    private final static String TAG = "Visitor";

    @Override
    public void visit(CommonEmployee commonEmployee) {
       Log.i(TAG,this.getCommmonEmployeeInfo(commonEmployee));
    }

    @Override
    public void visit(ManagerEmployee managerEmployee) {
        Log.i(TAG,this.getManagerInfo(managerEmployee));
    }

    private String getBaseInfo(Employee employee){
        String info = "姓名：" + employee.getName() + "\t";
        info = info + "性别：" + (employee.getSex() == Employee.MALE ? " 男":" 女") + "\t";
        info = info + "薪水：" + employee.getSalary() + "\t";

        return info;
    }

    private String getManagerInfo(ManagerEmployee managerEmployee){
        String baseInfo = this.getBaseInfo(managerEmployee);
        String otherInfo = "业绩:" + managerEmployee.getPerformance() + "\t";
        return baseInfo + otherInfo;
    }

    private String getCommmonEmployeeInfo(CommonEmployee commonEmployee){
        String baseInfo = this.getBaseInfo(commonEmployee);
        String otherInfo = "工作业绩:" + commonEmployee.getJob() + "\t";
        return baseInfo + otherInfo;
    }
}
