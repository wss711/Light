package com.gr.activemvcnote.controller;

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

import com.gr.activemvcnote.EnApplication;
import com.gr.activemvcnote.R;
import com.gr.activemvcnote.data.DataCallback;
import com.gr.activemvcnote.data.DiaryRepository;
import com.gr.activemvcnote.fragment.DiaryFragment;
import com.gr.activemvcnote.fragment.adapter.DiaryAdapter;
import com.gr.activemvcnote.model.Diary;
import com.gr.activemvcnote.observer.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-29
 **/
public class DiaryController implements Observer<Diary> {

    private final DiaryRepository mDiaryRepository;
    private final DiaryFragment mDiaryFragment;
    private DiaryAdapter mDiaryAdapter;

    public DiaryController(@NonNull DiaryFragment diaryFragment) {
        mDiaryRepository = DiaryRepository.getInstance();
        mDiaryFragment = diaryFragment;
        mDiaryFragment.setHasOptionsMenu(true);
        initAdapter();
    }

    private void initAdapter(){
        // 创建日记的适配器
        mDiaryAdapter = new DiaryAdapter(new ArrayList<Diary>());
        // 设置列表的条目长按事件
        mDiaryAdapter.setOnLongClickListener(new DiaryAdapter.OnLongClickListener<Diary>() {
            @Override
            public boolean onLongClick(View v, Diary data) {
                showInputDialog(data);
                return false;
            }
        });
    }

    public void setDiaryList(RecyclerView recyclerView){
        recyclerView.setLayoutManager(new LinearLayoutManager(mDiaryFragment.getContext()));
        recyclerView.setAdapter(mDiaryAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(mDiaryFragment.getContext(),DividerItemDecoration.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
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

    public void gotoWriteDiary(){
        showMessage(mDiaryFragment.getString(R.string.developing));
    }

    private void processDiary(List<Diary> diaryList){
        for(Diary diary : diaryList){
            diary.registerObserver(this);
        }
        mDiaryAdapter.update(diaryList);
    }

    private void showError(){
        showMessage(mDiaryFragment.getString(R.string.error));
    }

    private void showMessage(String message){
        Toast.makeText(mDiaryFragment.getContext(),message,Toast.LENGTH_SHORT).show();
    }

    private void showInputDialog(final Diary diary){
        final EditText editText = new EditText(mDiaryFragment.getContext());
        editText.setText(diary.getDescription());

        new AlertDialog.Builder(mDiaryFragment.getContext())
                .setTitle(diary.getTitle())
                .setView(editText)
                .setPositiveButton(EnApplication.getInstance().getString(R.string.ok),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                diary.setDescription(editText.getText().toString());
                                mDiaryRepository.update(diary);
                            }
                        })
                .setNegativeButton(EnApplication.getInstance().getString(R.string.cancel),null)
                .show();
    }

    @Override
    public void update(Diary data) {
        mDiaryRepository.update(data);
        loadDiary();
    }
}
