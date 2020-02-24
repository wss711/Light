package com.gr.mvcnote.Holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gr.mvcnote.R;
import com.gr.mvcnote.model.Diary;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-24
 **/
public class DiaryHolder  extends RecyclerViewHolder<Diary>{

    // 长按监听事件
    private View.OnLongClickListener mOnLongClickListener;

    public DiaryHolder(ViewGroup parent) {
        super(parent, R.layout.list_diary_item);
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener){
        this.mOnLongClickListener = onLongClickListener;
    }

    @Override
    public void onBindView(Diary diary) {
        super.onBindView(diary);

        TextView title = itemView.findViewById(R.id.title);
        title.setText(diary.getTitle());

        TextView desc = itemView.findViewById(R.id.desc);
        desc.setText(diary.getDescription());

        itemView.setOnLongClickListener(new View.OnLongClickListener() { // 设置长按监听
            @Override
            public boolean onLongClick(View v) {
                // 回调监听事件
                return mOnLongClickListener != null && mOnLongClickListener.onLongClick(v);
            }
        });
    }
}
