package com.gr.mvpclean.activity.fragment.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gr.mvpclean.activity.fragment.holder.DiaryHolder;
import com.gr.mvpclean.model.Diary;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-03-21
 **/
public class DiaryAdapter extends RecyclerView.Adapter<DiaryHolder> {

    private List<Diary> mDiaryList = new ArrayList<>(); // 日记数据
    private OnLongClickListener<Diary> mOnLongClickListener; // 长按监听

    /** 更新日记数据 */
    public void update(List<Diary> diaryList){
        this.mDiaryList = diaryList;
        notifyDataSetChanged();
    }

    /** 设置长按监听 */
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
        holder.setOnLongClickListener(v -> mOnLongClickListener != null &&
                mOnLongClickListener.onLongClick(v,diary));
    }

    @Override
    public int getItemCount() {
        return mDiaryList.size();
    }

    /** 长按监听的内部接口 */
    public interface OnLongClickListener<T> {

        boolean onLongClick(View v, T data);
    }
}
