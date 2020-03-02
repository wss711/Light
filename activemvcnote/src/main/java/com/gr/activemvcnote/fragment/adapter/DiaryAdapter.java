package com.gr.activemvcnote.fragment.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gr.activemvcnote.fragment.holder.DiaryHolder;
import com.gr.activemvcnote.model.Diary;

import java.util.List;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-03-02
 **/
public class DiaryAdapter extends RecyclerView.Adapter<DiaryHolder> {

    private List<Diary> mDiaryList; // 日记数据
    private OnLongClickListener<Diary> mOnLongClickListener; //长按监听

    public DiaryAdapter(List<Diary> diaryList){
        this.mDiaryList = diaryList;
    }

    public void update(List<Diary> diaryList){
        mDiaryList = diaryList;
        notifyDataSetChanged();
    }

    public void setOnLongClickListener(OnLongClickListener<Diary> onLongClickListener){
        this.mOnLongClickListener = onLongClickListener;
    }

    @NonNull
    @Override
    public DiaryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DiaryHolder(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull DiaryHolder holder, int position) {
        final Diary diary = mDiaryList.get(position);
        holder.onBindView(diary);
        holder.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return mOnLongClickListener != null && mOnLongClickListener.onLongClick(v,diary);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDiaryList.size();
    }

    public interface OnLongClickListener<T>{
        boolean onLongClick(View v,T data);
    }
}
