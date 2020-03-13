package com.jr.mvp.data.source;

import androidx.annotation.NonNull;

import com.jr.mvp.model.Diary;

import java.util.List;

import io.reactivex.Flowable;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-03-03
 **/
public interface DataSource<T> {

    // 获取所有数据
    Flowable<List<T>> getAll();
//    void getAll(@NonNull DataCallback<List<T>> callback);

    // 获取指定数据
    Flowable<T> get(@NonNull String id);
//    void get(@NonNull String id,@NonNull DataCallback<T> callback);

    // 更新指定数据
    void update(@NonNull T diary);

    // 清空所有数据
    void clear();

    // 删除指定数据
    void delete(@NonNull String id);

}
