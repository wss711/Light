package com.gr.activemvcnote.data.local;

import androidx.annotation.NonNull;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.gr.activemvcnote.data.DataCallback;
import com.gr.activemvcnote.data.DataSource;
import com.gr.activemvcnote.data.mock.MockDiary;
import com.gr.activemvcnote.model.Diary;
import com.gr.activemvcnote.utils.CollectionUtils;
import com.gr.activemvcnote.utils.GsonUtils;
import com.gr.activemvcnote.utils.SharedPreferencesUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-29
 **/
public class DiaryLocalDataSource implements DataSource<Diary> {

    private static final String DIARY_DATA = "diary_data";
    private static final String ALL_DIARY = "all_diary";

    private static SharedPreferencesUtils mSpUtils;
    private static Map<String,Diary> LOCAL_DATA = new LinkedHashMap<>();
    private static volatile DiaryLocalDataSource mInstance;

    public DiaryLocalDataSource() {
        mSpUtils = SharedPreferencesUtils.getInstance(DIARY_DATA);
        String diaryStr = mSpUtils.getString(ALL_DIARY);
        LinkedHashMap<String,Diary> diaryObj = json2Obj(diaryStr);
        if(!CollectionUtils.isEmpty(diaryObj)){
            LOCAL_DATA = diaryObj;
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
        if(diary != null){
            callback.onSuccess(diary);
        }else{
            callback.onError();
        }
    }

    @Override
    public void update(@NonNull Diary diary) {
        LOCAL_DATA.put(diary.getId(),diary);
        mSpUtils.put(ALL_DIARY,GsonUtils.toJson(LOCAL_DATA));
    }

    @Override
    public void clear() {
        LOCAL_DATA.clear();
        mSpUtils.remove(ALL_DIARY);
    }

    @Override
    public void delete(@NonNull String id) {
        LOCAL_DATA.remove(id);
        mSpUtils.put(ALL_DIARY,GsonUtils.toJson(LOCAL_DATA));
    }

    private LinkedHashMap<String,Diary> json2Obj(String diaryStr) {
        return GsonUtils.fromJson(diaryStr, new TypeToken<LinkedHashMap<String, Diary>>() {
        }.getType());
    }
}
