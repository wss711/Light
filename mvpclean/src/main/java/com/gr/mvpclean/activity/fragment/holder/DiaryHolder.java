package com.gr.mvpclean.activity.fragment.holder;


import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gr.mvpclean.R;
import com.gr.mvpclean.model.Diary;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-03-21
 **/
public class DiaryHolder extends RecyclerViewHolder<Diary> {

    private View.OnLongClickListener mOnLongClickListener;

    /** 传入日记布局 */
    public DiaryHolder(ViewGroup parent) {
        super(parent, R.layout.list_diary_item);
    }

    /** 设置长按监听 */
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    /** 绑定日记数据 */
    @Override
    public void onBindView(Diary diary) {
        super.onBindView(diary);

        TextView title = itemView.findViewById(R.id.title);
        title.setText(diary.getTitle());

        TextView desc = itemView.findViewById(R.id.desc);
        desc.setText(diary.getDescription());

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return mOnLongClickListener != null && mOnLongClickListener.onLongClick(v);
            }
        });
    }
}
