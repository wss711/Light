package com.gr.mvpclean.data;

import androidx.annotation.NonNull;

import com.gr.mvpclean.data.local.DiaryLocalDataSource;
import com.gr.mvpclean.data.source.DataCallback;
import com.gr.mvpclean.data.source.DataSource;
import com.gr.mvpclean.model.Diary;
import com.gr.mvpclean.utils.CollectionUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-03-21
 **/
public class DiaryRepository implements DataSource<Diary> {

    private static volatile DiaryRepository mInstance;
    private final DataSource<Diary> mLocalDataSource;

    private Map<String,Diary> mCache;   // 内存缓存

    private DiaryRepository(){
        mCache = new LinkedHashMap<>();
        mLocalDataSource = DiaryLocalDataSource.getInstance();
    }

    /** 获取数据仓库单例 */
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

        if(!CollectionUtils.isEmpty(mCache)){
            callback.onSuccess(new ArrayList<>(mCache.values()));
            return;
        }

        mLocalDataSource.getAll(new DataCallback<List<Diary>>() {
            @Override
            public void onSuccess(List<Diary> dataList) {
                updateCache(dataList); // 更新内存缓存数据
                callback.onSuccess(new ArrayList<>(mCache.values()));
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
                mCache.put(diary.getId(),diary);
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
        mCache.put(diary.getId(),diary);
    }

    @Override
    public void clear() {
        mLocalDataSource.clear();
        mCache.clear();
    }

    @Override
    public void delete(@NonNull String id) {
        mLocalDataSource.delete(id);
        mCache.remove(id);
    }


    /** 更新内存缓存 */
    private void updateCache(List<Diary> diaryList){
        mCache.clear();
        for (Diary diary : diaryList){
            mCache.put(diary.getId(),diary);
        }
    }

    /** 获取指定id的日记 */
    private Diary getDiaryByIdFromMemory(@NonNull String id){
        if(CollectionUtils.isEmpty(mCache)){
            return null;
        }else {
            return mCache.get(id);
        }
    }

}
