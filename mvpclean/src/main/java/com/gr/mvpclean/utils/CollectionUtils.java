package com.gr.mvpclean.utils;

import java.util.Map;

/**
 * TODO 集合工具类
 * <p>
 * Created by WSS on   2020-03-21
 **/
public final class CollectionUtils {

    public static boolean isEmpty(Map map){
        return map == null || map.isEmpty();
    }
}
