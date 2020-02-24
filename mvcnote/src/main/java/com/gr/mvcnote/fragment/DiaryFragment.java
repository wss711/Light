package com.gr.mvcnote.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.gr.mvcnote.R;

/**
 * TODO 日记展示页面
 * <p>
 * Created by WSS on  2020-02-24
 **/
public class DiaryFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // 加载日记页面布局
        View view = inflater.inflate(R.layout.fragment_diaries,container,false);

        return view;
    }
}
