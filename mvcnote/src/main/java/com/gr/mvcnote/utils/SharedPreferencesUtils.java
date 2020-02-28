package com.gr.mvcnote.utils;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.collection.SimpleArrayMap;

import com.gr.mvcnote.EnApplication;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-26
 **/
public final class SharedPreferencesUtils {

    // SharedPreferencesUtils工具类内存缓存，以SharedPreferencesUtils 的name为键
    private static final SimpleArrayMap<String,SharedPreferencesUtils> mCaches = new SimpleArrayMap<>();
    private SharedPreferences mSharedPreferences;

    private SharedPreferencesUtils(final String spName,final int mode){
        // 获得SharedPreferences对象
        mSharedPreferences = EnApplication.get().getSharedPreferences(spName,mode);
    }

   public static SharedPreferencesUtils getInstance(String spName){
       // 从内存缓存中获得SharedPreferences工具类
        SharedPreferencesUtils spUtils = mCaches.get(spName);
        if(spUtils == null){
            // 创建SharedPreferences工具类
            spUtils = new SharedPreferencesUtils(spName, Context.MODE_PRIVATE);
            // 将SharedPreferences工具类存入内存缓存
            mCaches.put(spName,spUtils);
        }
        return spUtils;
   }

   // 将数据存入SharedPreferences
   public void put(@NonNull final String key,final String value){
        mSharedPreferences.edit().putString(key,value).apply();
   }

   // 从SharedPreferences中获取数据
   public String get(@NonNull final String key){
        return mSharedPreferences.getString(key,"");
   }
   // 从SharedPreferences中删除数据
   public void remove(@NonNull final String key){
        mSharedPreferences.edit().remove(key).apply();
   }

}
