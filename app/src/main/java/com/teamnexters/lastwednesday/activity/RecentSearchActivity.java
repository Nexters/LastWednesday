package com.teamnexters.lastwednesday.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;

import com.teamnexters.lastwednesday.R;
import com.teamnexters.lastwednesday.fragment.adapter.RecentSearchAdapter;
import com.teamnexters.lastwednesday.model.MyData;
import com.teamnexters.lastwednesday.model.ShowRecentPlays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2018-02-10.
 */

public class RecentSearchActivity extends AppCompatActivity {
    public EditText search;
    private RecyclerView mRecyclerView;
    private List<ShowRecentPlays> RecentPlays;
    public RecentSearchAdapter rAdapter;
    private RecyclerView.LayoutManager mLayoutManger;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beginsearch);
        search = (EditText) findViewById(R.id.searchbar);

        mRecyclerView = findViewById(R.id.RecyclerViewRecentPlays);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManger = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(mLayoutManger);

        RecentPlays = new ArrayList<>();
        rAdapter = new RecentSearchAdapter(RecentPlays);
        mRecyclerView.setAdapter(rAdapter);

        RecentPlays.add(new ShowRecentPlays(R.drawable.ic_back));
        RecentPlays.add(new ShowRecentPlays(R.drawable.ic_back));
        RecentPlays.add(new ShowRecentPlays(R.drawable.ic_back));
        RecentPlays.add(new ShowRecentPlays(R.drawable.ic_back));
        RecentPlays.add(new ShowRecentPlays(R.drawable.ic_back));
        RecentPlays.add(new ShowRecentPlays(R.drawable.ic_back));
        RecentPlays.add(new ShowRecentPlays(R.drawable.ic_back));


        search.setInputType(InputType.TYPE_NULL);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecentSearchActivity.this, SearchActivity.class);
                startActivity(intent);
                overridePendingTransition(0,0);
                finish();
            }
        });



    }
}
