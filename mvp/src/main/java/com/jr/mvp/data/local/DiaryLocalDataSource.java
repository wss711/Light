package com.jr.mvp.data.local;

import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import com.google.gson.reflect.TypeToken;
import com.jr.mvp.data.mock.MockDiary;
import com.jr.mvp.data.source.DataCallback;
import com.jr.mvp.data.source.DataSource;
import com.jr.mvp.model.Diary;
import com.jr.mvp.utils.CollectionUtils;
import com.jr.mvp.utils.GsonUtils;
import com.jr.mvp.utils.SharedPreferencesUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-03-04
 **/
public class DiaryLocalDataSource implements DataSource<Diary> {

    private static final String DIARY_DATA = "diary_data";
    private static final String ALL_DIARY = "all_diary";

    private static SharedPreferencesUtils mSpUtils;
    private static Map<String,Diary> LOCAL_DATA = new LinkedHashMap<>();
    public static volatile DiaryLocalDataSource mInstance;

    private DiaryLocalDataSource(){
        mSpUtils = SharedPreferencesUtils.getInstance(DIARY_DATA);  // 获取获取SharedPreferences管理本地缓存
        String diaryStr = mSpUtils.get(ALL_DIARY);  // 获取本地日记信息
        LinkedHashMap<String,Diary> diaryObjMap = json2Obj(diaryStr);

        // 判断集合是否为空，不为空则将解析后的数据赋值给成员变量，否则，构造测试数据
        if(!CollectionUtils.isEmpty(diaryObjMap)){
            LOCAL_DATA = diaryObjMap;
        }else{
            LOCAL_DATA = MockDiary.mock();
        }
    }

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

    /** 获取所有的日记数据 */
    @Override
    public void getAll(@NonNull DataCallback<List<Diary>> callback) {
        if(LOCAL_DATA.isEmpty()){
            callback.onError();
        }else {
            callback.onSuccess(new ArrayList<>(LOCAL_DATA.values()));
        }
    }

    /** 获取指定日记 */
    @Override
    public void get(@NonNull String id, @NonNull DataCallback<Diary> callback) {
        Diary diary = LOCAL_DATA.get(id);
        if(diary != null){
            callback.onSuccess(diary);
        }else{
            callback.onError();
        }
    }

    /** 更新某个日记数据 */
    @Override
    public void update(@NonNull Diary diary) {
        LOCAL_DATA.put(diary.getId(),diary);
        mSpUtils.put(ALL_DIARY,obj2Json());
    }

    /** 清空日记数据 */
    @Override
    public void clear() {
        LOCAL_DATA.clear();
        mSpUtils.remove(ALL_DIARY);
    }

    /** 删除某个指定的日记数据 */
    @Override
    public void delete(@NonNull String id) {
        LOCAL_DATA.remove(id);
        mSpUtils.put(ALL_DIARY,obj2Json());
    }

    /** 将日记对象转换为日记数据 */
    private String obj2Json(){
        return GsonUtils.toJson(LOCAL_DATA);
    }

    /** 将日记数据转换为日记对象 */
    private LinkedHashMap<String,Diary> json2Obj(String diaryStr){
        return GsonUtils.fromJson(diaryStr,new TypeToken<LinkedHashMap<String,Diary>>(){}.getType());
    }
}
