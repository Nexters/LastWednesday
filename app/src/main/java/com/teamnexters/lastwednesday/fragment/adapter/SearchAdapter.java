package com.teamnexters.lastwednesday.fragment.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.teamnexters.lastwednesday.R;
import com.teamnexters.lastwednesday.model.MyData;

import java.util.List;

/**
 * Created by user on 2018-02-10.
 */
public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyViewHolder> {
    private List<MyData> mDataset;

    public SearchAdapter(List<MyData> myDataset) {
        mDataset = myDataset;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mplaytitle;
        public TextView mplaydate;
        public TextView mplayplace;

        public MyViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            mImageView = (ImageView) itemLayoutView.findViewById(R.id.poster);
            mplaytitle = (TextView) itemLayoutView.findViewById(R.id.play_title);
            mplaydate = (TextView)itemLayoutView.findViewById(R.id.play_date);
            mplayplace = (TextView)itemLayoutView.findViewById(R.id.play_place);

        }
    }


    @Override
    public SearchAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.plays_cardview, null);
        SearchAdapter.MyViewHolder myViewHolder = new SearchAdapter.MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final SearchAdapter.MyViewHolder viewHolder, final int position) {
        viewHolder.mplaytitle.setText(mDataset.get(position).text);
        viewHolder.mplaydate.setText(mDataset.get(position).text2);
        viewHolder.mplayplace.setText(mDataset.get(position).text3);
        viewHolder.mImageView.setImageResource(mDataset.get(position).img);
    }



    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
