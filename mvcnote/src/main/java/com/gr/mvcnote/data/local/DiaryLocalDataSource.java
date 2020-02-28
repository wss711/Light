package com.gr.mvcnote.data.local;

import androidx.annotation.NonNull;

import com.google.gson.reflect.TypeToken;
import com.gr.mvcnote.data.mock.MockDiary;
import com.gr.mvcnote.data.sourceinterface.DataCallback;
import com.gr.mvcnote.data.sourceinterface.DataSource;
import com.gr.mvcnote.model.Diary;
import com.gr.mvcnote.utils.CollectionUtils;
import com.gr.mvcnote.utils.GsonUtils;
import com.gr.mvcnote.utils.SharedPreferencesUtils;

import java.util.ArrayList;
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
        // 获取SharedPreferences管理本地缓存
        mSpUtils = SharedPreferencesUtils.getInstance(DIARY_DATA);
        // 获取本地日记信息
        String diaryStr = mSpUtils.get(ALL_DIARY);
        // 解析本地日记信息
        LinkedHashMap<String,Diary> diaryObjMap = json2Obj(diaryStr);
        if(!CollectionUtils.isEmpty(diaryObjMap)){
            LOCAL_DATA = diaryObjMap;
        }else{
            LOCAL_DATA = MockDiary.mock();
        }
    }

    // 获取日记本地数据源类的单例
    public static DiaryLocalDataSource getInstance(){
        if(mInstance == null){
            synchronized (DiaryLocalDataSource.class){
                if(mInstance == null){
                    mInstance = new DiaryLocalDataSource();
                }
            }
        }
        return mInstance;
    }

    @Override
    public void getAll(@NonNull DataCallback<List<Diary>> callback) {
        if(LOCAL_DATA.isEmpty()){
            callback.onError();
        }else{
            callback.onSuccess(new ArrayList<>(LOCAL_DATA.values()));
        }
    }

    @Override
    public void get(@NonNull String id, @NonNull DataCallback<Diary> callback) {
        Diary diary = LOCAL_DATA.get(id);
        if(diary == null){
            callback.onError();
        }else {
            callback.onSuccess(diary);
        }
    }

    @Override
    public void update(@NonNull Diary diary) {
        LOCAL_DATA.put(diary.getId(),diary);
        mSpUtils.put(ALL_DIARY,obj2Json());
    }

    @Override
    public void clear() {
        LOCAL_DATA.clear();
        mSpUtils.remove(ALL_DIARY);
    }

    @Override
    public void delete(@NonNull String id) {
        LOCAL_DATA.remove(id); // 删除内存某个日记数据
        mSpUtils.put(ALL_DIARY, obj2Json()); // 删除本地某个日记数据
    }

    private String obj2Json(){
        return GsonUtils.toJson(LOCAL_DATA);
    }

    private LinkedHashMap<String,Diary> json2Obj(String diaryStr){
        return GsonUtils.fromJson(diaryStr, new TypeToken<LinkedHashMap<String,Diary>>(){}.getType());
    }
}
