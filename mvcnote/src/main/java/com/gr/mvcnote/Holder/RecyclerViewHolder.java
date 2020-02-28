package com.gr.mvcnote.Holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * TODO 处理ViewHolder的一些基础方法，继承自RecyclerView组件ViewHolder。
 * <p>
 * Created by WSS on  2020-02-24
 **/
public class RecyclerViewHolder<T> extends RecyclerView.ViewHolder {

    // ViewHolder需要持有的数据
    private T mData;

    // 在构造方法中加载布局
    public RecyclerViewHolder(ViewGroup parent,@LayoutRes int resource) {
        super(LayoutInflater.from(parent.getContext()).inflate(resource,parent,false));
    }

    // 提示调用父类方法
    @CallSuper
    public void onBindView(T data){
        mData = data;
    }
    // 获取数据
    public T getData(){
        return mData;
    }
}
