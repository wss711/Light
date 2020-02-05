package com.gr.light.advanceview.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gr.light.R;
import java.util.List;


/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-03
 **/
public class FreshAdapter extends RecyclerView.Adapter<FreshAdapter.ViewHolder> {

    private List<Country> countryList;

    public FreshAdapter(List<Country> countryList) {
        this.countryList = countryList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;
        View itemView;
        public ViewHolder(@NonNull View view) {
            super(view);
            itemView = view;
            imageView = (ImageView)view.findViewById(R.id.flag_item_recyclerview_iv);
            textView = (TextView)view.findViewById(R.id.name_item_recyclerview_tv);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view,parent,false);
        final ViewHolder viewHolder = new ViewHolder(view);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = viewHolder.getLayoutPosition();
                addItem(pos,countryList.get(5));
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(countryList.get(position).getImgId());
        holder.textView.setText(countryList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    private void addItem(int position,Country country){
        countryList.add(position,country);
        notifyItemInserted(position);
    }

    private void removeData(int position){
        countryList.remove(position);
        notifyItemRemoved(position);
    }
}
