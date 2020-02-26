package com.gr.mvcnote.source;

import androidx.annotation.NonNull;

import com.gr.mvcnote.model.Diary;
import com.gr.mvcnote.source.DataCallback;
import com.gr.mvcnote.source.DataSource;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-24
 **/
public class DiaryLocalDataSource implements DataSource<Diary> {

    // 存储日记数据的SharedPreferences名称
    private static final String DIARY_DATA = "diary_data";
    // 存储日记数据的SharedPreferences键名
    private static final String ALL_DIARY = "all_diary";

    // SharedPreferences工具类
    private static SharedPreferencesUtils mSpUtils;
    // 本地数据的内存缓存
    private static Map<String,Diary> LOCAL_DATA= new LinkedHashMap<>();
    // 本地数据源,单例处理
    private static volatile DiaryLocalDataSource mInstance;

    // 单例化处理本地数据源
    private DiaryLocalDataSource(){
        mSpUtils =
    }



    @Override
    public void getAll(@NonNull DataCallback<List<Diary>> callback) {
        //
        // 我去你的
    }

    @Override
    public void get(@NonNull String id, @NonNull DataCallback<Diary> callback) {

    }

    @Override
    public void update(@NonNull Diary diary) {

    }

    @Override
    public void clear() {

    }

    @Override
    public void delete(@NonNull String id) {

    }
}
