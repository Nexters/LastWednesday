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
        dataSet.add(new Ticket("옥탑방고양이1", "2017.11.12~2018.01.12", "동숭아트신사홀", "픽션 , 액션", "120분", "12세",
                "홍길동, 김길동, 이길동, 박길동 외", "김둘리, 박둘리", false)); //임시데이터
        dataSet.add(new Ticket("옥탑방고양이2", "2017.11.12~2018.01.12", "동숭아트신사홀", "픽션 , 액션", "120분", "12세",
                "홍길동, 김길동, 이길동, 박길동 외", "김둘리, 박둘리", false)); //임시데이터
        dataSet.add(new Ticket("옥탑방고양이3", "2017.11.12~2018.01.12", "동숭아트신사홀", "픽션 , 액션", "120분", "12세",
                "홍길동, 김길동, 이길동, 박길동 외", "김둘리, 박둘리", false)); //임시데이터
        dataSet.add(new Ticket("옥탑방고양이4", "2017.11.12~2018.01.12", "동숭아트신사홀", "픽션 , 액션", "120분", "12세",
                "홍길동, 김길동, 이길동, 박길동 외", "김둘리, 박둘리", false)); //임시데이터
        dataSet.add(new Ticket("옥탑방고양이5", "2017.11.12~2018.01.12", "동숭아트신사홀", "픽션 , 액션", "120분", "12세",
                "홍길동, 김길동, 이길동, 박길동 외", "김둘리, 박둘리", false)); //임시데이터
        dataSet.add(new Ticket("옥탑방고양이6", "2017.11.12~2018.01.12", "동숭아트신사홀", "픽션 , 액션", "120분", "12세",
                "홍길동, 김길동, 이길동, 박길동 외", "김둘리, 박둘리", false)); //임시데이터
        dataSet.add(new Ticket("옥탑방고양이7", "2017.11.12~2018.01.12", "동숭아트신사홀", "픽션 , 액션", "120분", "12세",
                "홍길동, 김길동, 이길동, 박길동 외", "김둘리, 박둘리", false)); //임시데이터
        dataSet.add(new Ticket("옥탑방고양이8", "2017.11.12~2018.01.12", "동숭아트신사홀", "픽션 , 액션", "120분", "12세",
                "홍길동, 김길동, 이길동, 박길동 외", "김둘리, 박둘리", false)); //임시데이터
        dataSet.add(new Ticket("옥탑방고양이9", "2017.11.12~2018.01.12", "동숭아트신사홀", "픽션 , 액션", "120분", "12세",
                "홍길동, 김길동, 이길동, 박길동 외", "김둘리, 박둘리", false)); //임시데이터
        dataSet.add(new Ticket("옥탑방고양이10", "2017.11.12~2018.01.12", "동숭아트신사홀", "픽션 , 액션", "120분", "12세",
                "홍길동, 김길동, 이길동, 박길동 외", "김둘리, 박둘리", false)); //임시데이터
        dataSet.add(new Ticket("옥탑방고양이11", "2017.11.12~2018.01.12", "동숭아트신사홀", "픽션 , 액션", "120분", "12세",
                "홍길동, 김길동, 이길동, 박길동 외", "김둘리, 박둘리", false)); //임시데이터
        dataSet.add(new Ticket("옥탑방고양이12", "2017.11.12~2018.01.12", "동숭아트신사홀", "픽션 , 액션", "120분", "12세",
                "홍길동, 김길동, 이길동, 박길동 외", "김둘리, 박둘리", false)); //임시데이터

        adapter.updateDataSet(dataSet);
       onTabBtnClick(binding.textBtnShown);//임의로 호출
    }

    /*
     * 하단 메소드들은 API호출할 때 수정되야함.
     */
    private void setTicketCountText(int viewId) {
        switch(viewId) {
            case R.id.text_btn_shown :
                binding.textCount.setText("총 '" + adapter.getItemCount() + "' 편을 관람하셨습니다");
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
