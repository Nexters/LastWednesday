package com.teamnexters.lastwednesday.fragment.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.teamnexters.lastwednesday.R;
import com.teamnexters.lastwednesday.model.Play;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by user on 2018-02-10.
 */
public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyViewHolder> {
    private List<Play> mDataset;
    private PublishSubject<Play> mPublishSubject;

    public SearchAdapter(List<Play> myDataset) {
        this.mDataset = myDataset;
        this.mPublishSubject = PublishSubject.create();
    }

    public PublishSubject<Play> getmPublishSubject() {
        return mPublishSubject;
    }


    static class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView;
        private TextView mplaytitle;
        private TextView mplaydate;
        private TextView mplayplace;

        private MyViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            mImageView = (ImageView) itemLayoutView.findViewById(R.id.poster);
            mplaytitle = (TextView) itemLayoutView.findViewById(R.id.play_title);
            mplaydate = (TextView) itemLayoutView.findViewById(R.id.play_date);
            mplayplace = (TextView) itemLayoutView.findViewById(R.id.play_place);

        }

        private Observable<Play> getClickObservable( Play play) {
            return Observable.create( e -> {
                itemView.setOnClickListener(view -> e.onNext(play));
            });
        }
    }


    @Override
    public SearchAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_plays_cardview, parent, false);
        SearchAdapter.MyViewHolder myViewHolder = new SearchAdapter.MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final SearchAdapter.MyViewHolder viewHolder, final int position) {
        Play play = mDataset.get(position);
        viewHolder.mplaytitle.setText(mDataset.get(position).getTitle());
        viewHolder.mplaydate.setText(mDataset.get(position).getDate());
        viewHolder.mplayplace.setText(mDataset.get(position).getConcertHall());
        viewHolder.mImageView.setImageResource(mDataset.get(position).getPoster());

        viewHolder.getClickObservable(play).subscribe(mPublishSubject);

    }


    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
