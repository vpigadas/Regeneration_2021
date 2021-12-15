package com.codehub.regen_2021.recycler_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codehub.regen_2021.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public interface OnItemClickListener {
        /**
         * Called when a view has been clicked.
         *
         * @param v The view that was clicked.
         */
        void onClick(View v, String data);
    }

    private List<String> arrayData;
    private Context context;
    private OnItemClickListener listener;

    public MyAdapter(List<String> arrayData, Context context, OnItemClickListener listener) {
        this.arrayData = arrayData;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View view = LayoutInflater.from(context).inflate(R.layout.holder_list_item_2, parent, false);
            return new MyViewHolder2(view, listener);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.holder_list_item, parent, false);
            return new MyViewHolder(view, listener);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        String data = arrayData.get(position);
        holder.bind(data);
    }

    @Override
    public int getItemCount() {
        return arrayData.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
