package com.gr.mvcnote.source;

import androidx.annotation.NonNull;

import java.util.List;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-24
 **/
public interface DataSource<T> {

    // 获取所有数据
    void getAll(@NonNull DataCallback<List<T>> callback);
    // 获取指定id的某个数据
    void get(@NonNull String id, @NonNull DataCallback<T> callback);
    // 更新某个数据
    void update(@NonNull T diary);
    // 清除所有数据
    void clear();
    // 删除某条日记
    void delete(@NonNull String id);

}
