package com.teamnexters.lastwednesday.fragment.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.teamnexters.lastwednesday.R;
import com.teamnexters.lastwednesday.databinding.ItemReviewBinding;
import com.teamnexters.lastwednesday.model.Review;

import java.util.List;

/**
 * Created by JY on 2018-01-16.
 */

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder> {

    private List<Review> dataSet;

    public ReviewAdapter(List<Review> dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public ReviewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_review, parent, false);
        return new ReviewViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ReviewViewHolder holder, int position) {
        Review review = dataSet.get(position);
        holder.binding.setObj(review);
    }

    @Override
    public int getItemCount() {
        return (dataSet != null ? dataSet.size() : 0);
    }

    public void setDataSet(List<Review> dataSet) {
        this.dataSet = dataSet;
    }

    static class ReviewViewHolder extends RecyclerView.ViewHolder {

        ItemReviewBinding binding;

        public ReviewViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}
