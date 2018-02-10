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
import android.widget.Button;

import com.teamnexters.lastwednesday.R;
import com.teamnexters.lastwednesday.activity.SearchActivity;
import com.teamnexters.lastwednesday.databinding.FragmentTicketBinding;
import com.teamnexters.lastwednesday.fragment.adapter.TicketAdapter;
import com.teamnexters.lastwednesday.model.Ticket;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by JY on 2018-01-10.
 * <p>
 * Edited by Hyunsik on 2018-01-11.
 */

public class TicketFragment extends Fragment implements View.OnClickListener {

    FragmentTicketBinding binding;

    private LinearLayoutManager layoutManager;
    private TicketAdapter adapter;
    private List<Ticket> dataSet;
    private Button SearchPlays;

    public static TicketFragment newInstance() {
        TicketFragment fragment = new TicketFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_ticket, container, false);
        binding.setTicket(this);
        View view = binding.getRoot();

        initRecyclerview();

        dataSet = new ArrayList<>();
        dataSet.add(Ticket.of("옥탑방고양이", 19000, new Date())); //임시데이터
        dataSet.add(Ticket.of("넌센스2", 38000, new Date()));
        dataSet.add(Ticket.of("랄랄랄라 룰룰루", 47000, new Date()));

        SearchPlays = (Button) view.findViewById(R.id.search_plays);
        SearchPlays.setOnClickListener(this);

        return view;
    }

    private void initRecyclerview() {
        layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        adapter = new TicketAdapter(dataSet);

        binding.recyclerTicket.setLayoutManager(layoutManager);
        binding.recyclerTicket.setHasFixedSize(true);
        binding.recyclerTicket.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(), SearchActivity.class);
        startActivity(intent);
    }
}
