package com.gr.activemvcnote.fragment.holder;

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
 * Created by WSS on  2020-03-02
 **/
public class RecyclerViewHolder<T> extends RecyclerView.ViewHolder {

    private T mData;

    public RecyclerViewHolder(@NonNull ViewGroup parent, @LayoutRes int resource) {
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
