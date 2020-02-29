package com.gr.activemvcnote.data.local;

import androidx.annotation.NonNull;

import com.gr.activemvcnote.data.DataCallback;
import com.gr.activemvcnote.data.DataSource;
import com.gr.activemvcnote.model.Diary;

import java.util.List;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-29
 **/
public class DiaryLocalDataSource implements DataSource<Diary> {

    private static final String DIARY_DATA = "diary_data";
    private static final String ALL_DIARY = "all_diary";




    @Override
    public void getAll(@NonNull DataCallback<List<Diary>> callback) {

    }

    @Override
    public void get(@NonNull String id, @NonNull DataCallback<Diary> callback) {

    }

    @Override
    public void update(@NonNull Diary diary) {

    }

    @Override
    public void clear() {

    }

    @Override
    public void delete(@NonNull String id) {

    }
}
