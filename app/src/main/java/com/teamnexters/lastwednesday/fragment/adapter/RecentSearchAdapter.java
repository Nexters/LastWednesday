package com.teamnexters.lastwednesday.fragment.adapter;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.teamnexters.lastwednesday.R;
import com.teamnexters.lastwednesday.model.ShowRecentPlays;
import java.util.List;

/**
 * Created by user on 2018-02-10.
 */

public class RecentSearchAdapter extends RecyclerView.Adapter<RecentSearchAdapter.MyViewHolder> {
    public List<ShowRecentPlays> recentplays;
    public Context context;

    public RecentSearchAdapter(List<ShowRecentPlays> recentPlays) {
        recentplays = recentPlays;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView recentplay;
        public MyViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            recentplay = itemLayoutView.findViewById(R.id.recent_play_name);
        }

    }

    @Override
    public RecentSearchAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.recent_plays_cardview, parent, false);
        RecentSearchAdapter.MyViewHolder myViewHolder = new RecentSearchAdapter.MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final RecentSearchAdapter.MyViewHolder holder, int position) {
        holder.recentplay.setText(recentplays.get(position).recentplay);

    }


    @Override
    public int getItemCount() {
        return recentplays.size();
    }
}