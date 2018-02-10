package com.teamnexters.lastwednesday.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;


import com.teamnexters.lastwednesday.R;
import com.teamnexters.lastwednesday.fragment.adapter.SearchAdapter;
import com.teamnexters.lastwednesday.model.MyData;

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


