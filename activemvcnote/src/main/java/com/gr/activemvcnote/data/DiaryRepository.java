package com.gr.activemvcnote.data;

import androidx.annotation.NonNull;

import com.gr.activemvcnote.data.local.DiaryLocalDataSource;
import com.gr.activemvcnote.model.Diary;
import com.gr.activemvcnote.utils.CollectionUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-03-02
 **/
public class DiaryRepository implements DataSource<Diary> {

    private static volatile DiaryRepository mInstance;
    private final DataSource<Diary> mLocalDataSource;

    private Map<String,Diary> mMemoryCache;

    public DiaryRepository() {
        this.mLocalDataSource = DiaryLocalDataSource.getInstance();
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
    public void getAll(@NonNull final DataCallback<List<Diary>> callback) {
        if(mMemoryCache != null){
            callback.onSuccess(new ArrayList<>(mMemoryCache.values()));
            return;
        }

        mLocalDataSource.getAll(new DataCallback<List<Diary>>() {
            @Override
            public void onSuccess(List<Diary> diaryList) {
                updateMemoryCache(diaryList);
                callback.onSuccess(new ArrayList<>(mMemoryCache.values()));
            }

            @Override
            public void onError() {
                callback.onError();
            }
        });
    }

    @Override
    public void get(@NonNull String id, @NonNull final DataCallback<Diary> callback) {

        Diary cacheDiary = getDiaryById(id);

        if(cacheDiary != null){
            callback.onSuccess(cacheDiary);
            return;
        }

        mLocalDataSource.get(id, new DataCallback<Diary>() {
            @Override
            public void onSuccess(Diary diary) {
                getEnsureMemoryCache().put(diary.getId(),diary);
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
        getEnsureMemoryCache().put(diary.getId(),diary);
    }

    @Override
    public void clear() {
        mLocalDataSource.clear();
        getEnsureMemoryCache().clear();
    }

    @Override
    public void delete(@NonNull String id) {
        mLocalDataSource.delete(id);
        mMemoryCache.remove(id);
    }

    private void updateMemoryCache(List<Diary> diaryList){
        getEnsureMemoryCache().clear();
        for(Diary diary : diaryList){
            mMemoryCache.put(diary.getId(),diary);
        }
    }

    private Map<String,Diary> getEnsureMemoryCache(){
        if(mMemoryCache == null){
            mMemoryCache = new LinkedHashMap<>();
        }
        return mMemoryCache;
    }

    private Diary getDiaryById(@NonNull String id){
        if(CollectionUtils.isEmpty(mMemoryCache)){
            return null;
        }else{
            return mMemoryCache.get(id);
        }
    }
}
