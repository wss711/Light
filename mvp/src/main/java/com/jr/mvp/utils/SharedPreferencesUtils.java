package com.jr.mvp.utils;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.collection.SimpleArrayMap;

import com.jr.mvp.EnApplication;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-03-04
 **/
public class SharedPreferencesUtils {

    // SharedPreferences工具类内存缓存，以SharedPreferences  的name为键值
    private static final SimpleArrayMap<String,SharedPreferencesUtils> mCaches = new SimpleArrayMap<>();
    private SharedPreferences mSharedPreferences;

    private SharedPreferencesUtils(final String spName,final int mode){
        mSharedPreferences = EnApplication.getInstance().getSharedPreferences(spName,mode);
    }

    public static SharedPreferencesUtils getInstance(String spName){
        SharedPreferencesUtils spUtils = mCaches.get(spName);
        if(spUtils == null){
            spUtils = new SharedPreferencesUtils(spName, Context.MODE_PRIVATE);
            mCaches.put(spName,spUtils);
        }
        return spUtils;
    }

    public void put(@NonNull final String key,final String value){
        mSharedPreferences.edit().putString(key,value).apply();
    }

    public String get(@NonNull final String key){
        return mSharedPreferences.getString(key,"");
    }

    public void remove(@NonNull final String key){
        mSharedPreferences.edit().remove(key);
    }

}
