package com.gr.activemvcnote.fragment.holder;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.gr.activemvcnote.EnApplication;
import com.gr.activemvcnote.R;
import com.gr.activemvcnote.model.Diary;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-03-02
 **/
public class DiaryHolder extends RecyclerViewHolder<Diary> {

    private View.OnLongClickListener mOnLongClickListener;

    public DiaryHolder(ViewGroup parent){
        super(parent, R.layout.diary_item_list);
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
                return mOnLongClickListener !=null && mOnLongClickListener.onLongClick(v);
            }
        });
    }


}
