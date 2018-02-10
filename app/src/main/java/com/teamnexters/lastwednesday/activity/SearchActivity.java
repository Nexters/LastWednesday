package com.teamnexters.lastwednesday.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import com.teamnexters.lastwednesday.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2018-01-21.
 */

public class SearchActivity extends AppCompatActivity {    private RecyclerView mRecyclerView;
    public EditText search;
    public SearchAdapter mAdapter;
    private List<MyData> myDataset;
    private RecyclerView.LayoutManager mLayoutManger;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        search = (EditText) findViewById(R.id.search);
        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerViewPlays);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManger = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManger);
        myDataset = new ArrayList<>();
        mAdapter = new SearchAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);

        myDataset.add(new MyData("Wicked", "2018.00.00~2018.00.00", "Seoul", R.drawable.ic_back));
        myDataset.add(new MyData("Starbucks", "2018.00.00~2018.00.00", "no outlets", R.drawable.ic_back));
        myDataset.add(new MyData("Ediya", "2018.00.00~2018.00.00", "almost everywhere", R.drawable.ic_back));
        myDataset.add(new MyData("i don't know", "2018.00.00~2018.00.00", "i drank", R.drawable.ic_back));
        myDataset.add(new MyData("Apple", "2018.00.00~2018.00.00", "opened!", R.drawable.ic_back));
        myDataset.add(new MyData("Cats", "2018.00.00~2018.00.00", "So adorable", R.drawable.ic_back));
        myDataset.add(new MyData("Caffeine", "2018.00.00~2018.00.00", "i shake", R.drawable.ic_back));
        addTextListener();
    }

    public void addTextListener() {
        search.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence query, int start, int before, int count) {
                query = query.toString().toLowerCase();
                final List<MyData> filteredList = new ArrayList<>();
                for (int i = 0; i < myDataset.size(); i++) {
                    final String text = myDataset.get(i).text.toLowerCase();
                    if (text.contains(query)) {
                        filteredList.add(myDataset.get(i));
                    }
                }
                mRecyclerView.setLayoutManager(new LinearLayoutManager(SearchActivity.this));
                mAdapter = new SearchAdapter(filteredList);
                mRecyclerView.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();  // data set changed
            }
        });
    }
}

class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyViewHolder> {
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
        MyViewHolder myViewHolder = new MyViewHolder(view);
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


class MyData{
    public String text, text2, text3;
    public int img;
    public MyData(String text, String text2, String text3, int img){
        this.text = text;
        this.text2 = text2;
        this.text3 = text3;
        this.img=img;
    }
}

