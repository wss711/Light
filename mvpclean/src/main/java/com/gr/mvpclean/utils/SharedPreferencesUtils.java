package com.gr.mvpclean.utils;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.collection.SimpleArrayMap;

import com.gr.mvpclean.EnApplication;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-03-21
 **/
public final class SharedPreferencesUtils {

    private static final SimpleArrayMap<String,SharedPreferencesUtils> mCaches = new SimpleArrayMap<>();
    private SharedPreferences mSharedPreferences;

    private SharedPreferencesUtils(final String spName,final int mode){
        mSharedPreferences = EnApplication.getInstance().getSharedPreferences(spName, mode);
    }

    /** 创建SharedPreferencesUtils单例 */
    public static SharedPreferencesUtils getInstance(String spName){

        // 从内存缓存中获取SharedPreferences工具类
        SharedPreferencesUtils spUtils = mCaches.get(spName);
        if(spUtils == null){
            spUtils = new SharedPreferencesUtils(spName,Context.MODE_PRIVATE);
            mCaches.put(spName,spUtils);
        }

        return spUtils;
    }

    /** 将数据存入SharedPreferences */
    public void put(@NonNull final String key,final String value){
        mSharedPreferences.edit().putString(key,value).apply();
    }

    /** 从SharedPreferences中获取数据 */
    public String get(@NonNull final String key){
        return mSharedPreferences.getString(key,"");
    }

    /** 从SharedPreferences中删除数据 */
    public void remove(@NonNull final String key){
        mSharedPreferences.edit().remove(key).apply();
    }
}
