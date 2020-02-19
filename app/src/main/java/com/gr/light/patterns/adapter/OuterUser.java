package com.gr.light.patterns.adapter;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-19
 **/
public class OuterUser implements IOuterUser {
    @Override
    public Map getUserBaseInfo() {
        HashMap baseInfoMap = new HashMap();
        baseInfoMap.put("userName","这个员工的名字是：混世魔王");
        baseInfoMap.put("mobileNumber","这个员工的电话是：13652649871");
        return baseInfoMap;
    }

    @Override
    public Map getUserOfficeInfo() {
        HashMap officeMap = new HashMap();
        officeMap.put("jobPosition","这个员工的职位是：BOSS");
        officeMap.put("officeTelNumber","这个员工的电话是：13652649871");
        return officeMap;
    }

    @Override
    public Map getUserHomeInfo() {
        HashMap homeMap = new HashMap();
        homeMap.put("homeTelnNumber","这个员工的家庭电话是：028-51469874");
        homeMap.put("homeAddress","这个员工的家庭地址是：金太阳幼儿园");
        return homeMap;
    }
}
