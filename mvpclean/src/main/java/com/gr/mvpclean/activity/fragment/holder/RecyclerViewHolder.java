package com.gr.mvpclean.activity.fragment.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-03-21
 **/
public class RecyclerViewHolder<T> extends RecyclerView.ViewHolder {

    private T mData; //ViewHolder需要的数据

    /** 构造方法，加载界面布局 */
    public RecyclerViewHolder(ViewGroup parent, @LayoutRes int resource) {
        super(LayoutInflater.from(parent.getContext()).inflate(resource,parent,false));
    }

    /** 提示调用父类方法, 绑定数据 */
    public void onBindView(T data){
        mData = data;
    }

    /** 获取数据 */
    public T getData(){
        return mData;
    }
}
