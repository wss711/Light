package com.gr.light.patterns.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-22
 **/
public class Client {
    private final static String TAG = "Visitor";

    public static void execute(){
        for(Employee employee : mockEmployee()){
            employee.accept(new Visitor());
        }

    }

    public static List<Employee> mockEmployee(){
        List<Employee> employeeList = new ArrayList<>();

        //
        CommonEmployee zhangsan = new CommonEmployee();
        zhangsan.setJob("初级Java程序猿");
        zhangsan.setName("张三");
        zhangsan.setSalary(2500);
        zhangsan.setSex(Employee.MALE);
        employeeList.add(zhangsan);
        CommonEmployee lisi = new CommonEmployee();
        lisi.setJob("页面美工，审美太不主流了");
        lisi.setName("李四");
        lisi.setSalary(2500);
        lisi.setSex(Employee.FEMALE);
        employeeList.add(lisi);
        ManagerEmployee wangwu = new ManagerEmployee();
        wangwu.setPerformance("王五，马屁精");
        wangwu.setName("王五");
        wangwu.setSalary(25000);
        wangwu.setSex(Employee.MALE);
        employeeList.add(wangwu);

        return employeeList;
    }
}
