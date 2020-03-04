package com.jr.mvp.main.list.holder;

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
 * Created by WSS on  2020-03-04
 **/
public class RecyclerViewHolder<T> extends RecyclerView.ViewHolder {

    // ViewHolder需要的数据
    private T mData;

    public RecyclerViewHolder(ViewGroup parent, @LayoutRes int resource) {
        super(LayoutInflater.from(parent.getContext()).inflate(resource,parent,false));
    }

    @CallSuper
    public void onBindView(T data){
        mData = data;
    }

    public T getData(){
        return mData;
    }
}
