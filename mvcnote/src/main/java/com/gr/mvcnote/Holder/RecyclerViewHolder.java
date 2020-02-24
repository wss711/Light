package com.gr.mvcnote.Holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-24
 **/
public class RecyclerViewHolder<T> extends RecyclerView.ViewHolder {

    // ViewHolder需要的数据
    private T mData;

    public RecyclerViewHolder(ViewGroup parent, @LayoutRes int resource) {
        // 构造方法，加载界面布局
        super(LayoutInflater.from(parent.getContext()).inflate(resource,parent,false));
    }
    @CallSuper
    public void onBindView(T data){
        mData = data;
    }

    public T getmData() {
        return mData;
    }
}
