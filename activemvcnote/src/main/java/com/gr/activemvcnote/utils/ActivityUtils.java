package com.gr.activemvcnote.utils;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-29
 **/
public class ActivityUtils {
    public static void addFragment2Activity(@NonNull FragmentManager fragmentManager,
                                            @NonNull Fragment fragment,int frameId){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(frameId,fragment);

        transaction.commit();
    }
}
