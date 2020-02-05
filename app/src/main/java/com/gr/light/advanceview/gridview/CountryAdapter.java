package com.gr.light.advanceview.gridview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.gr.light.R;

import java.util.List;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-03
 **/
public class CountryAdapter extends ArrayAdapter<Country> {
    int resId;

    public CountryAdapter(@NonNull Context context, int resource, @NonNull List<Country> objects) {
        super(context, resource, objects);
        //记录布局资源id
        resId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //获取当前位置条目的数据实例
        Country country = getItem(position);
        View view;
        ViewHolder holder = null;

        //当convertView不为空 复用converView
        if (convertView == null){
            holder = new ViewHolder();
            //将xml转换成view对象
            view = View.inflate(getContext(),resId,null);
            holder.imageView = view.findViewById(R.id.flag_item_gridview_iv);
            holder.textView = view.findViewById(R.id.name_item_gridview_iv);
            // 将viewHolder保存到view对象中
            view.setTag(holder);
        }else {
            view = convertView;
            holder = (ViewHolder)view.getTag();
        }
        // 填充数据
        holder.imageView.setImageResource(country.getImgId());
        holder.textView.setText(country.getName());

        return view;
    }

    static class ViewHolder{
        ImageView imageView;
        TextView textView;
    }


}
