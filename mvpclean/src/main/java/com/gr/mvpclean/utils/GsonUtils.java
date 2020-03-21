package com.gr.mvpclean.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-03-21
 **/
public final class GsonUtils {

    private static final Gson GSON = createGson();

    /** 对象转换为json */
    public static String toJson(final Object obj){
        return GSON.toJson(obj);
    }

    /** 将JSON格式String转换为对象 */
    public static <T> T fromJson(final String json, final Type type){
        return GSON.fromJson(json,type);
    }

    /** 创建Gson实例 */
    private static Gson createGson(){
        final GsonBuilder builder = new GsonBuilder();
        builder.serializeNulls();

        return builder.create();
    }
}
