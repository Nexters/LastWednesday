package com.teamnexters.lastwednesday.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;


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
    public ImageButton Backtosearch;
    public SearchAdapter mAdapter;
    public TextView searchresults;
    private List<MyData> myDataset;
    private RecyclerView.LayoutManager mLayoutManger;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        search = findViewById(R.id.search);
        searchresults = findViewById(R.id.searchresult);
        Backtosearch = findViewById(R.id.backtosearch);
        mRecyclerView = findViewById(R.id.RecyclerViewPlays);

        mRecyclerView.setHasFixedSize(true);
        mLayoutManger = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManger);

        myDataset = new ArrayList<>();
        mAdapter = new SearchAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);

        Backtosearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchActivity.this, RecentSearchActivity.class);
                startActivity(intent);
                overridePendingTransition(0,0);
                finish();
            }
        });


        myDataset.add(new MyData("킹키부츠", "2018.01.31~2018.04.01", "블루스퀘어 인터파크홀", R.drawable.kinkyboots));
        myDataset.add(new MyData("안나 카레리나", "2018.03.02~2018.03.04", "대전 예술의전당 아트홀", R.drawable.anna));
        myDataset.add(new MyData("빌리 엘리어트", "2017.11.28~2018.05.07", "디큐브아트센터", R.drawable.billyelliot));
        myDataset.add(new MyData("빨래", "2018.03.09~오픈런", "동양예술극장 1관", R.drawable.laundry));
        myDataset.add(new MyData("김종욱 찾기", "2018.01.26~2019.01.25", "대학로 쁘띠첼씨어터", R.drawable.findkim));
        myDataset.add(new MyData("닥터 지바고", "2018.02.27~2018.05.07", "샤롯데씨어터", R.drawable.zhivago));
        myDataset.add(new MyData("오! 당신이 잠든사이", "2017.12.01~2018.02.25", "대학로 드림아트센터 4관", R.drawable.whieyourasleep));
        myDataset.add(new MyData("명성황후", "2018.05.11~2018.05.13", "울산문화예술회관 대공연장", R.drawable.myeongseong));
        myDataset.add(new MyData("광화문연가", "2018.03.02~2018.03.04", "광주문화예술회관 대극장", R.drawable.kwmyg));
        myDataset.add(new MyData("루나틱", "2017.09.20~2018.03.31", "대학로 문 씨어터", R.drawable.lunatic));
        myDataset.add(new MyData("마마돈크라이", "2018.03.23~2018.07.01", "대학로 아트원씨어터 1관", R.drawable.mamadontcry));
        myDataset.add(new MyData("작업의 정석", "2017.12.01~2018.03.31", "대학로 아트포레스트 2관", R.drawable.jakup));
        myDataset.add(new MyData("프리즌", "2018.01.24~2018.03.04", "대학로 이수아트홀", R.drawable.freezen));
        myDataset.add(new MyData("쉬즈블루", "2018.01.07~2018.03.04", "가든씨어터", R.drawable.shesblue));
        myDataset.add(new MyData("브라보 마이 러브", "2018.05.04~2018.05.27", "세종문화회관 M씨어터", R.drawable.bravomylove));
        myDataset.add(new MyData("페인터즈 히어로", "2017.03.01~2018.04.30", "제주관광대학교 컨벤션홀", R.drawable.hero));
        myDataset.add(new MyData("홀연했던 사나이", "2018.02.06~2018.04.15", "충무아트센터 중극장 블랙", R.drawable.dude));
        myDataset.add(new MyData("레드북", "2018.02.06~2018.03.30", "세종문화회관 M씨어터", R.drawable.redbook));
        myDataset.add(new MyData("최후진술", "2017.12.10~2018.02.25", "충무아트센터 소극장 블루", R.drawable.laststate));
        myDataset.add(new MyData("마이 버킷 리스트", "2018.02.04~2018.03.18", "CJ아지트 대학로", R.drawable.mybucketlist));
        myDataset.add(new MyData("투모로우 모닝", "2018.03.01~2018.03.31", "대학로 JTN 아트홀 2관", R.drawable.tmorning));
        myDataset.add(new MyData("그대와 영원히", "2018.01.31~2018.03.31", "대학로 한성아트홀 2관", R.drawable.wuforever));
        myDataset.add(new MyData("안나카레리나", "2018.03.10~2018.03.11", "한국소리문화의전당 모악당", R.drawable.anna));
        myDataset.add(new MyData("아이러브유", "2017.12.14~2018.03.11", "대학로 아트원씨어터 1관", R.drawable.iloveyou));
        myDataset.add(new MyData("꽃보다 슈퍼스타", "2017.04.01~2018.03.31", "마로니에 극장", R.drawable.superstar));
        myDataset.add(new MyData("광화문연가", "2018.02.23~2018.02.25", "인천문화예술회관 대공연장", R.drawable.kwmyg));
        myDataset.add(new MyData("모래시계", "2018.02.23~2018.02.25", "광주문화예술회관 대극장", R.drawable.sandclock));
        myDataset.add(new MyData("더 라스트 키스", "2017.12.15~2018.03.11", "LG 아트센터", R.drawable.lastkiss));
        myDataset.add(new MyData("브라더스 까라마조프", "2018.02.10~2018.04.15", "수현재씨어터", R.drawable.brothers));
        myDataset.add(new MyData("젊음의 행진", "2018.03.13~2018.05.27", "충무아트센터 대극장", R.drawable.youthmarch));
        myDataset.add(new MyData("명성황후", "2018.04.19~2018.04.22", "계명아트센터", R.drawable.myeongseong));
        myDataset.add(new MyData("광화문연가", "2018.03.16~2018.03.18", "부산시민회관 대극장", R.drawable.kwmyg));
        myDataset.add(new MyData("더 픽션", "2018.03.09~2018.04.21", "KT&G상상마당 대치아트홀", R.drawable.thefiction));
        myDataset.add(new MyData("삼총사", "2018.03.16~2018.05.27", "한전아트센터", R.drawable.threemusketers));
        myDataset.add(new MyData("적벽", "2018.03.15~2018.04.15", "정동극장", R.drawable.jb));

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
                searchresults.setText("검색결과" + " ( " + filteredList.size() + " )");
                mRecyclerView.setLayoutManager(new LinearLayoutManager(SearchActivity.this));
                mAdapter = new SearchAdapter(filteredList);
                mRecyclerView.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();  // data set changed
            }
        });
    }
}


