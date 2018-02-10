package com.teamnexters.lastwednesday.fragment.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.teamnexters.lastwednesday.R;
import com.teamnexters.lastwednesday.model.MyData;
import com.teamnexters.lastwednesday.model.ShowRecentPlays;

import java.util.List;

/**
 * Created by user on 2018-02-10.
 */

public class RecentSearchAdapter extends RecyclerView.Adapter<RecentSearchAdapter.MyViewHolder> {
    public List<ShowRecentPlays> recentplays;

    public RecentSearchAdapter(List<ShowRecentPlays> recentPlays) {
        recentplays = recentPlays;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView recentposter;
            public MyViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            recentposter = (ImageView) itemLayoutView.findViewById(R.id.poster);
    }

}

    @Override
    public RecentSearchAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.recent_plays_cardview, null);
        RecentSearchAdapter.MyViewHolder myViewHolder = new RecentSearchAdapter.MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final RecentSearchAdapter.MyViewHolder holder, int position) {
        holder.recentposter.setImageResource(recentplays.get(position).img);
    }


    @Override
    public int getItemCount() {
        return recentplays.size();
    }
}
