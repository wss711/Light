package com.gr.mvcnote.utils;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-24
 **/
public final class ActivityUtils {
    public static void addFragment2Activity(@NonNull FragmentManager fragmentManager,
                                            @NonNull Fragment fragment, int frameId){
        // Fragment事务开始
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 添加Fragment，frameId为fragment的id
        transaction.add(frameId,fragment);
        // 提交事务
        transaction.commit();
    }
}
