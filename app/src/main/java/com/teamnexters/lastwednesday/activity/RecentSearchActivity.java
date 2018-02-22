package com.teamnexters.lastwednesday.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.teamnexters.lastwednesday.R;
import com.teamnexters.lastwednesday.fragment.TicketFragment;
import com.teamnexters.lastwednesday.fragment.adapter.RecentSearchAdapter;
import com.teamnexters.lastwednesday.model.ShowRecentPlays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2018-02-10.
 */

public class RecentSearchActivity extends AppCompatActivity {
    public ImageButton BackToTicket;
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
        BackToTicket = findViewById(R.id.backtomyticket);
        mRecyclerView = findViewById(R.id.RecyclerViewRecentPlays);
        mLayoutManger = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManger);

        RecentPlays = new ArrayList<>();
        rAdapter = new RecentSearchAdapter(RecentPlays);
        mRecyclerView.setAdapter(rAdapter);

        RecentPlays.add(new ShowRecentPlays("안나 카레리나"));
        RecentPlays.add(new ShowRecentPlays("아이러브유"));
        RecentPlays.add(new ShowRecentPlays("광화문연가"));
        RecentPlays.add(new ShowRecentPlays("오! 당신이 잠든사이"));
        RecentPlays.add(new ShowRecentPlays("투모로우 모닝"));
        RecentPlays.add(new ShowRecentPlays("천로역정"));
        RecentPlays.add(new ShowRecentPlays("마마돈크라이"));
        RecentPlays.add(new ShowRecentPlays("홀연했던 사나이"));
        RecentPlays.add(new ShowRecentPlays("루나틱"));
        RecentPlays.add(new ShowRecentPlays("캣츠"));
        RecentPlays.add(new ShowRecentPlays("빌리 엘리엇"));
        RecentPlays.add(new ShowRecentPlays("작업의 정석"));


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