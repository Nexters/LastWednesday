package com.teamnexters.lastwednesday.fragment;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.teamnexters.lastwednesday.R;
import com.teamnexters.lastwednesday.activity.SearchActivity;
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

public class TicketFragment extends Fragment  {

    FragmentTicketBinding binding;

    private LinearLayoutManager layoutManager;
    private TicketAdapter adapter;
    private List<Ticket> dataSet;

    public static TicketFragment newInstance () {
        TicketFragment fragment = new TicketFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onCreate ( @Nullable Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView ( LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_ticket, container, false);
        binding.setTicket(this);
        View view = binding.getRoot();


        binding.toolbar.toolbarSearch.setContentInsetsAbsolute(0, 0);
        binding.toolbar.toolbarSearch.setNavigationIcon(null);
        binding.toolbar.setTicket(this);

        dataSet = new ArrayList<>();
        dataSet.add(new Ticket("옥탑방고양이", "2017.11.12~2018.01.12", "동숭아트신사홀", "픽션 , 액션", "120분", "12세",
                "홍길동, 김길동, 이길동, 박길동 외", "김둘리, 박둘리", false)); //임시데이터
        dataSet.add(new Ticket("옥탑방고양이", "2017.11.12~2018.01.12", "동숭아트신사홀", "픽션 , 액션", "120분", "12세",
                "홍길동, 김길동, 이길동, 박길동 외", "김둘리, 박둘리", false)); //임시데이터

        return view;
    }

    @Override
    public void onActivityCreated ( @Nullable Bundle savedInstanceState ) {
        super.onActivityCreated(savedInstanceState);
        initRecyclerview();
    }
    private void initRecyclerview () {
        layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        adapter = new TicketAdapter();
        adapter.updateData(dataSet);

        binding.recyclerTicket.setLayoutManager(layoutManager);
        binding.recyclerTicket.setHasFixedSize(true);
        binding.recyclerTicket.setAdapter(adapter);
    }



    public void onSearchClick ( View v ) {
        Intent intent = new Intent(getActivity(), SearchActivity.class);
        startActivity(intent);
    }

}
