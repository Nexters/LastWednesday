package com.teamnexters.lastwednesday.fragment;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.teamnexters.lastwednesday.MainActivity;
import com.teamnexters.lastwednesday.R;
import com.teamnexters.lastwednesday.activity.RecentSearchActivity;
import com.teamnexters.lastwednesday.databinding.FragmentTicketBinding;
import com.teamnexters.lastwednesday.fragment.adapter.TicketAdapter;
import com.teamnexters.lastwednesday.model.Ticket;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JY on 2018-01-10.
 * <p>
 * Edited by Hyunsik on 2018-01-11.
 */

public class TicketFragment extends Fragment {

    FragmentTicketBinding binding;

    private LinearLayoutManager layoutManager;
    private TicketAdapter adapter;
    private List<Ticket> dataSet;

    public static TicketFragment newInstance() {
        TicketFragment fragment = new TicketFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true); //옵션메뉴 사용가능하도록 설정해줌
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_ticket, container, false);
        binding.setTicket(this);
        View view = binding.getRoot();


        return view;
    }

    private void initToolbar() {
        MainActivity activity = (MainActivity) getActivity();
        Toolbar toolbar = binding.toolbar.toolbarTicket;
        activity.setSupportActionBar(toolbar);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initToolbar();
        initRecyclerview();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) { //툴바에 검색메뉴 생성
        inflater.inflate(R.menu.search_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_search: {
                startActivity(new Intent(getActivity(), RecentSearchActivity.class));
                return true;
            }
        }
        return false;
    }

    private void initRecyclerview() {
        layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setSmoothScrollbarEnabled(true);

        adapter = new TicketAdapter(getActivity());
        adapter.onLongClickEventPublish();
        adapter.onCheckedChangeEventPublish();

        binding.recyclerTicket.setLayoutManager(layoutManager);
        binding.recyclerTicket.setHasFixedSize(true);
        binding.recyclerTicket.setAdapter(adapter);



        dataSet = new ArrayList<>();
        dataSet.add(new Ticket("오! 당신이 잠든사이", "2017.12.01~2018.02.25", "대학로 드림아트센터 4관", "드라마", "110분",
                "만 10세 이상", "김동현, 장한얼, 라준, 이소희 등", "연출-장혜성, 작곡가-김혜성", R.drawable.whieyourasleep, false));
        dataSet.add(new Ticket("명성황후", "2018.05.11~2018.05.13", "울산문화예술회관 대공연장", "드라마", "150분",
                "만 7세 이상", "김소현, 양준보, 오종혁 등", "", R.drawable.myeongseong, false));
        dataSet.add(new Ticket("광화문연가", "2018.03.02~2018.03.04", "광주문화예술회관 대극장", "드라마", "150분",
                "만 7세 이상", "안재욱, 차지연, 바강현, 이연경 등", "연출-이지나, 극본-고선웅, 음악감독-김성수", R.drawable.kwmyg, false));
        dataSet.add(new Ticket("루나틱", "2017.09.20~2018.03.31", "대학로 문 씨어터", "드라마", "100분",
                "만 13세 이상", "엄선영, 차재성, 정효정, 방보용 등", "", R.drawable.lunatic, false));
        dataSet.add(new Ticket("마마돈크라이", "2018.03.23~2018.07.01", "대학로 아트원씨어터 1관", "드라마, 판타지", "100분",
                "만 14세 이상", "송용진, 조형균, 박영수, 고훈정 등", "", R.drawable.mamadontcry, false));
        dataSet.add(new Ticket("작업의 정석", "2017.12.01~2018.03.31", "대학로 아트포레스트 2관", "로맨스", "90분",
                "만 13세 이상", "조준휘 등", "", R.drawable.jakup, false));
        dataSet.add(new Ticket("프리즌", "2018.01.24~2018.03.04", "대학로 이수아트홀", "드라마, 수사", "100분",
                "48개월 이상", "김두현, 김민호, 이진현", "", R.drawable.freezen, false));
        dataSet.add(new Ticket("킹키부츠", "2018.01.31~2018.04.01", "블루스퀘어 인터파크홀", "드라마",  "140분",
                "만 7세 이상", "김호영, 정성화, 김지우, 고창석 등" , "", R.drawable.kinkyboots, false));
        dataSet.add(new Ticket("안나 카레리나", "2018.03.02~2018.03.04", "예술의 전당 오페라극장", "드라마, 픽션", "150분",
                "8세 이상","옥주현, 이지훈, 황성현, 기세중 등", "알리나 체비크", R.drawable.anna, false));
        dataSet.add(new Ticket("빌리 엘리어트", "2017.11.28~2018.05.07", "디큐브아트센터", "드라마, 가족", "175분" ,
                "미취학 아동 입장불가", "김갑수, 최명경, 최정원 등", "", R.drawable.billyelliot, false));
        dataSet.add(new Ticket("빨래", "2018.03.09~오픈런", "동양예술극장 1관", "드라마", "160분",
                "만 13세 이상", "하은설, 조상웅, 장이주, 이세령 등", "", R.drawable.laundry, false));
        dataSet.add(new Ticket("김종욱 찾기", "2018.01.26~2019.01.25", "대학로 쁘띠첼씨어터", "로맨스", "100분",
                "만 7세 이상", "김동현, 서은교, 황재훈", "", R.drawable.findkim, false));
        dataSet.add(new Ticket("닥터 지바고", "2018.02.27~2018.05.07", "샤롯데씨어터", "드라마", "170분",
                "만 7세 이상", "류정한, 조정은, 최민철 등", "", R.drawable.zhivago, false));

        adapter.updateDataSet(dataSet);
       onTabBtnClick(binding.textBtnShown);//임의로 호출
    }

    /*
     * 하단 메소드들은 API호출할 때 수정되야함.
     */
    private void setTicketCountText(int viewId) {
        switch(viewId) {
            case R.id.text_btn_shown :
                binding.textCount.setText("총 '250' 편을 관람하셨습니다");
                break;
            case R.id.text_btn_wishlist:
                binding.textCount.setText("총 '" + adapter.getItemCount() + "' 편을 위시리스트에 추가하셨습니다");
        }
    }

    public void onTabBtnClick(View v) { //클릭하면 버튼의 백그라운드색과 글자색을 변경
        int id = v.getId();
        GradientDrawable bgView = (GradientDrawable) v.getBackground();
        bgView.setColor(getResources().getColor(R.color.cSkyblue));

        if (id == R.id.text_btn_shown) {
            binding.textBtnShown.setTextColor(getResources().getColor(R.color.cWhite));
            setTicketCountText(id);

            GradientDrawable bgWishlist = (GradientDrawable) binding.textBtnWishlist.getBackground();
            bgWishlist.setColor(getResources().getColorStateList(R.color.cWhite));
            binding.textBtnWishlist.setTextColor(getResources().getColor(R.color.cSkyblue));
        } else if (id == R.id.text_btn_wishlist) {
            binding.textBtnWishlist.setTextColor(getResources().getColor(R.color.cWhite));
            setTicketCountText(id);

            GradientDrawable bgShown = (GradientDrawable) binding.textBtnShown.getBackground();
            bgShown.setColor(getResources().getColorStateList(R.color.cWhite));
            binding.textBtnShown.setTextColor(getResources().getColor(R.color.cSkyblue));
        }
    }
}
