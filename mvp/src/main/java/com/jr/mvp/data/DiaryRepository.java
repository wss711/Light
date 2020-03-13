package com.jr.mvp.data;

import androidx.annotation.NonNull;

import com.jr.mvp.data.local.DiaryLocalDataSource;
import com.jr.mvp.data.source.DataCallback;
import com.jr.mvp.data.source.DataSource;
import com.jr.mvp.model.Diary;
import com.jr.mvp.utils.CollectionUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Flowable;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-03-03
 **/
public class DiaryRepository implements DataSource<Diary> {

    private static volatile DiaryRepository mInstance;
    private final DataSource<Diary> mLocalDataSource;

    // 内存缓存
    private Map<String,Diary> mCacheMap;

    private DiaryRepository(){
        mCacheMap = new LinkedHashMap<>();
        mLocalDataSource = DiaryLocalDataSource.getInstance();
    }

    public static DiaryRepository getInstance(){
        if(mInstance == null){
            synchronized (DiaryRepository.class){
                if (mInstance == null){
                    mInstance = new DiaryRepository();
                }
            }
        }
        return mInstance;
    }

    @Override
    public Flowable<List<Diary>> getAll() {
        // 缓存数据不为空
        if(!CollectionUtils.isEmpty(mCacheMap)){
            return Flowable.fromIterable(mCacheMap.values()).toList().toFlowable();
        }

        // 否则，读取本地数据到内存
        return mLocalDataSource.getAll()
                .flatMap(diaryList -> Flowable.fromIterable(diaryList)
                .doOnNext(diary -> mCacheMap.put(diary.getId(),diary))
                .toList()
                .toFlowable());
    }

    @Override
    public Flowable<Diary> get(@NonNull String id) {
        Diary cachedDiary = getDiaryByIdFromMemory(id);

        // 内存中存在此实例
        if(cachedDiary != null){
            return Flowable.just(cachedDiary);
        }
        // 否则，
        return mLocalDataSource.get(id)
                .doOnNext(diary -> {
                    if(diary != null){
                        mCacheMap.put(diary.getId(),diary);
                    }
                });
    }

    @Override
    public void update(@NonNull Diary diary) {
        mLocalDataSource.update(diary);
        mCacheMap.put(diary.getId(),diary);
    }

    @Override
    public void clear() {
        mLocalDataSource.clear();
        mCacheMap.clear();
    }

    @Override
    public void delete(@NonNull String id) {
        mLocalDataSource.delete(id);
        mCacheMap.remove(id);
    }

    private void updateMemoryCache(List<Diary> diaryList){
        mCacheMap.clear();
        for(Diary diary : diaryList){
            mCacheMap.put(diary.getId(),diary);
        }
    }

    @NonNull
    private Diary getDiaryByIdFromMemory(@NonNull String id){
        if(CollectionUtils.isEmpty(mCacheMap)){
            return null;
        }else {
            return mCacheMap.get(id);
        }
    }


    //
//    @Override
//    public void getAll(@NonNull final DataCallback<List<Diary>> callback) {
//
//        // 优先处理内存数据
//        if(!CollectionUtils.isEmpty(mCacheMap)){
//            callback.onSuccess(new ArrayList<>(mCacheMap.values()));
//            return;
//        }
//        // 其次，处理本地数据
//        mLocalDataSource.getAll(new DataCallback<List<Diary>>() {
//            @Override
//            public void onSuccess(List<Diary> data) {
//                updateMemoryCache(data);
//                callback.onSuccess(new ArrayList<>(mCacheMap.values()));
//            }
//
//            @Override
//            public void onError() {
//                callback.onError();
//            }
//        });
//    }
//
//    @Override
//    public void get(@NonNull String id, @NonNull final DataCallback<Diary> callback) {
//
//        final Diary cachedDiary = getDiaryByIdFromMemory(id);
//
//        if(cachedDiary != null){
//            callback.onSuccess(cachedDiary);
//            return;
//        }
//
//        mLocalDataSource.get(id, new DataCallback<Diary>() {
//            @Override
//            public void onSuccess(Diary data) {
//                mCacheMap.put(data.getId(),data);
//                callback.onSuccess(data);
//            }
//
//            @Override
//            public void onError() {
//                callback.onError();
//            }
//        });
//    }
}
