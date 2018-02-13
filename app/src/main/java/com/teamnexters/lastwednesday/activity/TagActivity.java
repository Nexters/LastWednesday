package com.teamnexters.lastwednesday.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.cunoraz.tagview.TagView;
import com.teamnexters.lastwednesday.R;

public class TagActivity extends AppCompatActivity {

    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tag);

        mContext = this;


        TagView tag_recommand = (TagView) findViewById(R.id.tag_recommand);
        TagView tag_genre = (TagView) findViewById(R.id.tag_genre);
        TagView tag_place = (TagView) findViewById(R.id.tag_place);


        String[] tagString_genre = {"미스터리", "판타지", "로맨스", "코미디", "드라마",
                "시대극", "팩션", "스릴러", "블록버스터", "주크박스", "액터뮤지션", "아동청소년극", "넌버벌퍼포먼스"};
        String[] tagString_place = {"국립극장(해오름)", "디큐브아트센터", "블루스퀘어(삼성전자홀, 삼성카드홀)", "샤롯데씨어터", "세종문화회관(대극장)",
                "우리금융아트홀", "LG아트센터", "예술의전당(오페라극장, CJ토월극장)", "충무아트센터(대극장, 중극장 블랙, 소극장 블루)",
                "코엑스아티움", "한전아트센터", "대학로", "기타"};

        tag_genre.addTags(tagString_genre);
        tag_place.addTags(tagString_place);
    }
}
