package com.gr.mvcnote.fragment;

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

import com.gr.mvcnote.R;
import com.gr.mvcnote.controller.DiaryController;

/**
 * TODO 日记展示页面
 * <p>
 * Created by WSS on  2020-02-24
 **/
public class DiaryFragment extends Fragment {

    private DiaryController mController;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 在此处引入日记控制器。
        mController = new DiaryController(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // 加载日记页面布局
        View view = inflater.inflate(R.layout.fragment_diaries,container,false);
        // 将日记列表控件传入控制器
        mController.setDiaryList();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        // 加载日记列表
        mController.loadDiaryList();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        // 加载菜单的布局文件
        inflater.inflate(R.menu.menuz_write,menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_add:
                // 通知控制器添加新的日记
                mController.gotoWriteDiary();
                return true;
                break;
        }
        // 返回false代表菜单点击选择事件没有被处理
        return false;
    }
}
