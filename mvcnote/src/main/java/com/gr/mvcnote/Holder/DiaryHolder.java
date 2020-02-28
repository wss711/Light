package com.gr.mvcnote.Holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gr.mvcnote.R;
import com.gr.mvcnote.model.Diary;

import java.util.List;

/**
 * TODO 日记的Holder，传入数据类型为Diary
 * <p>
 * Created by WSS on  2020-02-24
 **/
public class DiaryHolder extends RecyclerViewHolder<Diary>{

    private View.OnLongClickListener mOnLongClickListener;

    public DiaryHolder(ViewGroup parent) {
        super(parent, R.layout.list_diary_item);    // 传入日记布局XML
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener){
        this.mOnLongClickListener = onLongClickListener;
    }
    @Override
    public void onBindView(Diary diary) {
        super.onBindView(diary);
        //  加载标题控件
        TextView title = itemView.findViewById(R.id.title);
        title.setText(diary.getTitle());

        // 加载详情控件
        TextView desc = itemView.findViewById(R.id.desc);
        desc.setText(diary.getDescription());

        // 回调监听事件
        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return mOnLongClickListener != null && mOnLongClickListener.onLongClick(v);
            }
        });
    }
}
