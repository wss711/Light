package com.jr.mvp.main.list.holder;



import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jr.mvp.R;
import com.jr.mvp.model.Diary;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-03-04
 **/
public class DiaryHolder extends RecyclerViewHolder<Diary> {

    private View.OnLongClickListener mOnLongClickListener;

    public DiaryHolder(ViewGroup parent){
        super(parent, R.layout.item_diary);
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

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return mOnLongClickListener != null && mOnLongClickListener.onLongClick(v);
            }
        });

    }
}
