package com.gr.mvpclean.data.local;

import androidx.annotation.NonNull;

import com.google.gson.reflect.TypeToken;
import com.gr.mvpclean.data.mock.MockDiary;
import com.gr.mvpclean.data.source.DataCallback;
import com.gr.mvpclean.data.source.DataSource;
import com.gr.mvpclean.model.Diary;
import com.gr.mvpclean.utils.CollectionUtils;
import com.gr.mvpclean.utils.GsonUtils;
import com.gr.mvpclean.utils.SharedPreferencesUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-03-21
 **/
public class DiaryLocalDataSource implements DataSource<Diary> {

    private static final String DIARY_DATA = "diary_data"; // 存储日记数据的SharedPreferences名称
    private static final String ALL_DIARY = "all_diary"; // 存储日记数据的SharedPreferences键名

    private static SharedPreferencesUtils mSpUtils;     // SharedPreferences工具类
    private static Map<String,Diary> LOCAL_DATA = new LinkedHashMap<>();    // 本地数据内存缓存
    private static volatile DiaryLocalDataSource mInstance;     // 本地数据源

    private DiaryLocalDataSource(){
        mSpUtils = SharedPreferencesUtils.getInstance(DIARY_DATA); // 获取SharedPreferences管理本地缓存
        String diaryStr = mSpUtils.get(ALL_DIARY); // 获取本地日记信息
        LinkedHashMap<String,Diary> diaryObj = json2Obj(diaryStr);
        if(!CollectionUtils.isEmpty(diaryObj)){ //判断集合是否不为空
            LOCAL_DATA = diaryObj; // 不为空则将解析后的值赋予成员变量
        }else{
            LOCAL_DATA = MockDiary.mock(); // 测试数据
        }
    }

    /** 获取日记本地数据源类的单例 */
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
            callback.onSuccess(new ArrayList<>(LOCAL_DATA.values())); // 通知查询成功
        }
    }

    @Override
    public void get(@NonNull String id, @NonNull DataCallback<Diary> callback) {
        Diary diary = LOCAL_DATA.get(id);
        if(diary != null){
            callback.onSuccess(diary);
        }else {
            callback.onError();
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
        LOCAL_DATA.remove(id);
        mSpUtils.put(ALL_DIARY,obj2Json());
    }

    /** 将日记对象转换成JSON格式 */
    private String obj2Json(){
        return GsonUtils.toJson(LOCAL_DATA);
    }
    /** 将日记json数据转换为日记对象 */
    private LinkedHashMap<String,Diary> json2Obj(String diaryStr){
        return GsonUtils.fromJson(diaryStr,new TypeToken<LinkedHashMap<String,Diary>>(){}.getType());
    }
}
