package com.gr.mvpclean.utils;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-03-21
 **/
public final class ActivityUtils {

    public static void addFragment2Activity(@NonNull FragmentManager fragmentManager,
                                            @NonNull Fragment fragment,
                                            int frameId){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(frameId,fragment);
        transaction.commit();

    }
}
