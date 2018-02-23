package com.teamnexters.lastwednesday.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.teamnexters.lastwednesday.R;
import com.teamnexters.lastwednesday.databinding.ActivitySearchBinding;
import com.teamnexters.lastwednesday.fragment.adapter.SearchAdapter;
import com.teamnexters.lastwednesday.model.Play;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2018-01-21.
 */

public class SearchActivity extends AppCompatActivity {
    ActivitySearchBinding binding;
    private RecyclerView mRecyclerView;
    public EditText search;
    public ImageButton Backtosearch;
    public SearchAdapter mAdapter;
    public TextView searchresults;
    private List<Play> myDataset;
    private RecyclerView.LayoutManager mLayoutManger;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search);
        binding.setActivity(this);

        search = findViewById(R.id.search);
        searchresults = findViewById(R.id.searchresult);
        Backtosearch = findViewById(R.id.backtosearch);
        mRecyclerView = findViewById(R.id.RecyclerViewPlays);

        mRecyclerView.setHasFixedSize(true);
        mLayoutManger = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManger);

        myDataset = new ArrayList<>();
        mAdapter = new SearchAdapter(myDataset);
        mAdapter.getmPublishSubject().subscribe(
                data -> goToPlayInfoActivity(data)
        );
        mRecyclerView.setAdapter(mAdapter);

        Backtosearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchActivity.this, RecentSearchActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                finish();
            }
        });


        myDataset.add(new Play("킹키부츠", "2018.01.31~2018.04.01", "블루스퀘어 인터파크홀", "드라마",  "140분",
                "만 7세 이상", "김호영, 정성화, 김지우, 고창석 등" , "", R.drawable.kinkyboots, false));
        myDataset.add(new Play("안나 카레리나", "2018.03.02~2018.03.04", "예술의 전당 오페라극장", "드라마, 픽션", "150분",
                "8세 이상","옥주현, 이지훈, 황성현, 기세중 등", "알리나 체비크", R.drawable.anna, false));
        myDataset.add(new Play("빌리 엘리어트", "2017.11.28~2018.05.07", "디큐브아트센터", "드라마, 가족", "175분" ,
                "미취학 아동 입장불가", "김갑수, 최명경, 최정원 등", "", R.drawable.billyelliot, false));
        myDataset.add(new Play("빨래", "2018.03.09~오픈런", "동양예술극장 1관", "드라마", "160분",
                "만 13세 이상", "하은설, 조상웅, 장이주, 이세령 등", "", R.drawable.laundry, false));
        myDataset.add(new Play("김종욱 찾기", "2018.01.26~2019.01.25", "대학로 쁘띠첼씨어터", "로맨스", "100분",
                "만 7세 이상", "김동현, 서은교, 황재훈", "", R.drawable.findkim, false));
        myDataset.add(new Play("닥터 지바고", "2018.02.27~2018.05.07", "샤롯데씨어터", "드라마", "170분",
                "만 7세 이상", "류정한, 조정은, 최민철 등", "", R.drawable.zhivago, false));
        myDataset.add(new Play("오! 당신이 잠든사이", "2017.12.01~2018.02.25", "대학로 드림아트센터 4관", "드라마", "110분",
                "만 10세 이상", "김동현, 장한얼, 라준, 이소희 등", "", R.drawable.whieyourasleep, false));
        myDataset.add(new Play("명성황후", "2018.05.11~2018.05.13", "울산문화예술회관 대공연장", "드라마", "150분",
                "만 7세 이상", "김소현, 양준보, 오종혁 등", "", R.drawable.myeongseong, false));
        myDataset.add(new Play("광화문연가", "2018.03.02~2018.03.04", "광주문화예술회관 대극장", "드라마", "150분",
                "만 7세 이상", "안재욱, 차지연, 바강현, 이연경 등", "연출-이지나, 극본-고선웅, 음악감독-김성수", R.drawable.kwmyg, false));
        myDataset.add(new Play("루나틱", "2017.09.20~2018.03.31", "대학로 문 씨어터", "드라마", "100분",
                "만 13세 이상", "엄선영, 차재성, 정효정, 방보용 등", "", R.drawable.lunatic, false));
        myDataset.add(new Play("마마돈크라이", "2018.03.23~2018.07.01", "대학로 아트원씨어터 1관", "드라마, 판타지", "100분",
                "만 14세 이상", "송용진, 조형균, 박영수, 고훈정 등", "", R.drawable.mamadontcry, false));
        myDataset.add(new Play("작업의 정석", "2017.12.01~2018.03.31", "대학로 아트포레스트 2관", "로맨스", "90분",
                "만 13세 이상", "조준휘 등", "", R.drawable.jakup, false));
        myDataset.add(new Play("프리즌", "2018.01.24~2018.03.04", "대학로 이수아트홀", "드라마, 수사", "100분",
                "48개월 이상", "김두현, 김민호, 이진현", "", R.drawable.freezen, false));
        myDataset.add(new Play("쉬즈블루", "2018.01.07~2018.03.04", "대학로 가든씨어터", "드라마", "120분",
                "만 12세 이상", "이동민, 김기석, 남우승 김지경, 유이준 등", "홍모세 등", R.drawable.shesblue, false));
        myDataset.add(new Play("브라보 마이 러브", "2018.05.04~2018.05.27", "세종문화회관 M씨어터", "드라마", "125분",
                "만 13세 이상", "미확정", "", R.drawable.bravomylove, false));
        myDataset.add(new Play("페인터즈 히어로", "2017.03.01~2018.04.30", "제주관광대학교 컨벤션홀", "퍼포먼스", "75분",
                "전체관람가", "김흥남, 김병남", "", R.drawable.hero, false));
        myDataset.add(new Play("홀연했던 사나이", "2018.02.06~2018.04.15", "충무아트센터 중극장 블랙", "드라마", "110분",
                "만 7세 이상", "정민, 오종혁, 강영석, 임진아 등", "", R.drawable.dude, false));
        myDataset.add(new Play("안나카레리나", "2018.03.10~2018.03.11", "한국소리문화의전당 모악당", "드라마, 픽션", "150분",
                "8세 이상","옥주현, 이지훈, 황성현, 기세중 등", "알리나 체비크", R.drawable.anna, false));
        myDataset.add(new Play("아이러브유", "2017.12.14~2018.03.11", "대학로 아트원씨어터 1관" , "드라마, 로맨스", "130분",
                "만 14세 이상", "고영빈, 김찬호, 정욱진, 최수진 등", "",  R.drawable.iloveyou, true));
        myDataset.add(new Play("꽃보다 슈퍼스타", "2017.04.01~2018.03.31", "마로니에 극장", "드라마", "90분",
                "7세 이상", "오선미, 김다솔, 김은재, 정여은 등", "", R.drawable.superstar, true));
        myDataset.add(new Play("광화문연가", "2018.02.23~2018.02.25", "인천문화예술회관 대공연장", "드라마", "150분",
                "만 7세 이상", "안재욱, 차지연, 바강현, 이연경 등", "연출-이지나, 극본-고선웅, 음악감독-김성수, ", R.drawable.kwmyg, true));

        addTextListener();
    }

    public void goToPlayInfoActivity(Play play) {
        Intent intent = new Intent(getApplicationContext(), PlayInfoActivity.class);
        intent.putExtra("OBJECT", play);
        startActivity(intent);
    }

    public void addTextListener() {
        search.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence query, int start, int before, int count) {
                query = query.toString().toLowerCase();
                final List<Play> filteredList = new ArrayList<>();
                for (int i = 0; i < myDataset.size(); i++) {
                    final String text = myDataset.get(i).getTitle().toLowerCase();
                    if (text.contains(query)) {
                        filteredList.add(myDataset.get(i));
                    }
                }
                searchresults.setText("검색결과" + " ( " + filteredList.size() + " )");
                mAdapter = new SearchAdapter(filteredList);
                mAdapter.getmPublishSubject().subscribe(
                        data -> goToPlayInfoActivity(data)
                );
                mRecyclerView.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();  // data set changed
            }
        });
    }
    public void onTagBtnClick(View v) {
        startActivity(new Intent(getApplicationContext(), TagActivity.class));
    }
}


