package com.teamnexters.lastwednesday.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.teamnexters.lastwednesday.R;

import java.util.List;

/**
 * Created by user on 2018-01-22.
 */

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyViewHolder> {
    private List<String> list_item;
    public Context mcontext;


    public SearchAdapter(List<String> list, Context context) {
        list_item = list;
        mcontext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.list_item, null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder viewHolder, final int position) {
        viewHolder.play_name.setText(list_item.get(position));
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView play_name;

        public MyViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            play_name = (TextView) itemLayoutView.findViewById(R.id.play_name);
        }
    }

    @Override
    public int getItemCount() {
        return list_item.size();
    }
}
