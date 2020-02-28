package com.gr.mvcnote.controller;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gr.mvcnote.EnApplication;
import com.gr.mvcnote.R;
import com.gr.mvcnote.adapter.DiaryAdapter;
import com.gr.mvcnote.data.DiaryRepository;
import com.gr.mvcnote.data.sourceinterface.DataCallback;
import com.gr.mvcnote.fragment.DiaryFragment;
import com.gr.mvcnote.model.Diary;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-24
 **/
public class DiaryController {

    private final DiaryRepository mDiaryRepository; // 引入数据仓库
    private final DiaryFragment mView; // 引入视图
    private DiaryAdapter mDiaryAdapter;

    public DiaryController(@NonNull DiaryFragment diaryFragment) {
        this.mDiaryRepository = DiaryRepository.getInstance();
        this.mView = diaryFragment;
        mView.setHasOptionsMenu(true);
        initAdapter();
    }

    private void initAdapter(){
        // 创建日记列表的适配器
        mDiaryAdapter = new DiaryAdapter(new ArrayList<Diary>());
        // 设置列表条目的长按事件的监听器
        mDiaryAdapter.setOnLongClickListener(new DiaryAdapter.OnLongClickListener<Diary>() {
            @Override
            public boolean onLongClick(View v, Diary diary) {
                showInputDialog(diary);
                return false;
            }
        });
    }

    private void showInputDialog(Diary diary){
        // 创建输入框
        final EditText editText = new EditText(mView.getContext());
        // 设置输入框默认文字为日志详情信息
        editText.setText(diary.getDescription());

        new AlertDialog.Builder(mView.getContext()).setTitle(diary.getTitle())
                .setView(editText)
                .setPositiveButton(EnApplication.get().getString(R.string.ok),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) { // 确认按钮点击监听
                                diary.setDescription(editText.getText().toString()); // 修改日记信息为输入框信息
                                mDiaryRepository.update(diary); // 更新日记数据
                                loadDiary(); // 重新加载列表
                            }
                        })
                .setNegativeButton(EnApplication.get().getString(R.string.cancel), null).show(); // 弹出对话框
    }


    public void loadDiary(){
        mDiaryRepository.getAll(new DataCallback<List<Diary>>() {
            @Override
            public void onSuccess(List<Diary> diaryList) {
                processDiary(diaryList);
            }

            @Override
            public void onError() {
                showError();
            }
        });

    }

    private void processDiary(List<Diary> listDiary){
        mDiaryAdapter.update(listDiary);
    }

    private void showError(){
        showMessage(mView.getString(R.string.error));
    }

    private void showMessage(String message){
        Toast.makeText(mView.getContext(),message,Toast.LENGTH_SHORT).show();
    }

    public void setDiaryList(RecyclerView recyclerView){
        recyclerView.setLayoutManager(new LinearLayoutManager(mView.getContext()));
        recyclerView.setAdapter(mDiaryAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(mView.getContext(),DividerItemDecoration.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    public void gotoWriteDiary() {
        showMessage(mView.getString(R.string.developing)); // 弹出功能未开放提示
    }
}
