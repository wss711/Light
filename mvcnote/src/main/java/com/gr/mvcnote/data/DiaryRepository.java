package com.gr.mvcnote.data;

import androidx.annotation.NonNull;

import com.gr.mvcnote.data.local.DiaryLocalDataSource;
import com.gr.mvcnote.data.sourceinterface.DataCallback;
import com.gr.mvcnote.data.sourceinterface.DataSource;
import com.gr.mvcnote.model.Diary;
import com.gr.mvcnote.utils.CollectionUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-27
 **/
public class DiaryRepository implements DataSource<Diary> {

    private static volatile DiaryRepository mInstance;
    private final DataSource<Diary> mLocalDataSource;

    private Map<String,Diary> mMemoryCaches;

    private DiaryRepository() {
        mMemoryCaches = new LinkedHashMap<>();
        mLocalDataSource = DiaryLocalDataSource.getInstance();
    }

    public static DiaryRepository getInstance(){
        if(mInstance == null){
            synchronized (DiaryRepository.class){
                if(mInstance == null){
                    mInstance = new DiaryRepository();
                }
            }
        }

        return mInstance;
    }

    @Override
    public void getAll(@NonNull DataCallback<List<Diary>> callback) {
        if(!CollectionUtils.isEmpty(mMemoryCaches)){
            callback.onSuccess(new ArrayList<>(mMemoryCaches.values()));
            return;
        }

        mLocalDataSource.getAll(new DataCallback<List<Diary>>() {
            @Override
            public void onSuccess(List<Diary> diaryList) {
                updateMemoryCache(diaryList);
                callback.onSuccess(new ArrayList<>(mMemoryCaches.values()));
            }

            @Override
            public void onError() {
                callback.onError();
            }
        });
    }

    @Override
    public void get(@NonNull String id, @NonNull DataCallback<Diary> callback) {

        Diary cacheDiary = getDiaryByIdFromMemory(id);

        if(cacheDiary != null){
            callback.onSuccess(cacheDiary);
            return;
        }

        mLocalDataSource.get(id, new DataCallback<Diary>() {
            @Override
            public void onSuccess(Diary diary) {
                mMemoryCaches.put(diary.getId(),diary);
                callback.onSuccess(diary);
            }

            @Override
            public void onError() {
                callback.onError();
            }
        });
    }

    @Override
    public void update(@NonNull Diary diary) {
        mLocalDataSource.update(diary);
        mMemoryCaches.put(diary.getId(),diary);
    }

    @Override
    public void clear() {
        mLocalDataSource.clear();
        mMemoryCaches.clear();
    }

    @Override
    public void delete(@NonNull String id) {
        mLocalDataSource.delete(id);
        mMemoryCaches.remove(id);
    }

    private void updateMemoryCache(List<Diary> diaryList){
        mMemoryCaches.clear();
        for(Diary diary : diaryList){
            mMemoryCaches.put(diary.getId(),diary);
        }
    }

    @NonNull
    private Diary getDiaryByIdFromMemory(@NonNull String id){
        if(CollectionUtils.isEmpty(mMemoryCaches)){
            return null;
        }
        else{
            return mMemoryCaches.get(id);
        }
    }
}
