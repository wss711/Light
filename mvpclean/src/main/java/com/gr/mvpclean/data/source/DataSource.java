package com.gr.mvpclean.data.source;

import androidx.annotation.NonNull;

import java.util.List;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-03-21
 **/
public interface DataSource<T> {

    void getAll(@NonNull DataCallback<List<T>> callback);

    void get(@NonNull String id,@NonNull DataCallback<T> callback);

    void update(@NonNull T diary);

    void clear();

    void delete(@NonNull String id);
}
