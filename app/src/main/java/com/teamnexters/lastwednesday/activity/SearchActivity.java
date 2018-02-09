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
import com.teamnexters.lastwednesday.adapter.SearchAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2018-01-21.
 */

public class SearchActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    public EditText search;
    private List<String> list = new ArrayList<String>();
    public SearchAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        search = (EditText) findViewById(R.id.search);
        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerViewPlays);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        playList();
        mAdapter = new SearchAdapter(list, this);
        mRecyclerView.setAdapter(mAdapter);

        addTextListener();
    }

    public void playList() {
        list.add("광화문 연가");
        list.add("금발이 너무해");
        list.add("누가 내머리에 똥쌌어?");
        list.add("우리 아이가 달라졌어요");
        list.add("옥탑방 고양이");
        list.add("캣츠 : 내한공연");
        list.add("빌리 엘리엇");
        list.add("김종욱 찾기");
        list.add("공룡이 살아있다");
        list.add("라나 델 레이 : LA TO The MOON");
        list.add("복순이할배");
        list.add("춤추는 꼬마공주 소피아");
        list.add("김광석뮤지컬 : 마흔즈음에");
        list.add("오즈의 마법사");

    }

    public void addTextListener() {
        search.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence query, int start, int before, int count) {
                query = query.toString().toLowerCase();
                final List<String> filteredList = new ArrayList<>();
                for (int i = 0; i < list.size(); i++) {
                    final String text = list.get(i).toLowerCase();
                    if (text.contains(query)) {
                        filteredList.add(list.get(i));
                    }
                }
                mRecyclerView.setLayoutManager(new LinearLayoutManager(SearchActivity.this));
                mAdapter = new SearchAdapter(filteredList, SearchActivity.this);
                mRecyclerView.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();  // data set changed
            }
        });
    }
}
