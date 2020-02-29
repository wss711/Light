package com.gr.activemvcnote.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.gr.activemvcnote.R;
import com.gr.activemvcnote.controller.DiaryController;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-29
 **/
public class DiaryFragment extends Fragment {

    DiaryController mController;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 在此声明周期引入DiaryController
        mController = new DiaryController(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // 在此处引入视图
        View rootView = inflater.inflate(R.layout.diary_fragment,container,false);
        // 设置日记Item
        mController.setDiaryList((RecyclerView)rootView.findViewById(R.id.diary_list));

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mController.loadDiary();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_write,menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_add:
                mController.gotoWriteDiary();
                return true;
        }
        return false;
    }
}
