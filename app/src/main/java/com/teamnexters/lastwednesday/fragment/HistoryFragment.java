package com.teamnexters.lastwednesday.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.teamnexters.lastwednesday.R;
import com.teamnexters.lastwednesday.databinding.FragmentHistoryBinding;
import com.teamnexters.lastwednesday.fragment.adapter.ReviewAdapter;
import com.teamnexters.lastwednesday.model.Review;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by JY on 2018-01-10.
 * <p>
 * Edited by Hyunsik on 2018-01-11.
 */

public class HistoryFragment extends Fragment {

    FragmentHistoryBinding binding;

    private ReviewAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Review> dataSet;

    public static HistoryFragment newInstance() {
        HistoryFragment fragment = new HistoryFragment();
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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_history, container, false);
        View rootView = binding.getRoot();
        binding.setHistory(this);

        dataSet = new ArrayList<>();
        dataSet.add(Review.of("옥탑방고양이", "정말정말재밌어요", 4.5, new Date())); //임시데이터
        dataSet.add(Review.of("넌센스2", "정말정말재밌어요", 5, new Date()));
        dataSet.add(Review.of("랄랄랄라 룰룰루", "정말정말재밌어요", 3.5, new Date()));
        dataSet.add(Review.of("위키드", "정말정말재밌어요", 4.5, new Date()));
        dataSet.add(Review.of("캣츠", "정말정말재밌어요", 5, new Date()));
        dataSet.add(Review.of("띠로리", "정말정말재밌어요", 3.5, new Date()));

        initRecyclerview();

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private void initRecyclerview() {
        adapter = new ReviewAdapter(dataSet.subList(0, 3));
        layoutManager = new LinearLayoutManager(getActivity());

        binding.recyclerReview.setAdapter(adapter);
        binding.recyclerReview.setLayoutManager(layoutManager);
        binding.recyclerReview.setHasFixedSize(true);
    }

    public void onSeeMoreClick(View view) { //테스트
        if (adapter.getItemCount() == 3) {
            adapter.setDataSet(dataSet);
            adapter.notifyDataSetChanged();
        }
    }


}
