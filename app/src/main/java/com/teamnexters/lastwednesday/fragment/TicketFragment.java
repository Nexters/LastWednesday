package com.teamnexters.lastwednesday.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.teamnexters.lastwednesday.R;

/**
 * Created by JY on 2018-01-10.
 *
 * Edited by Hyunsik on 2018-01-11.
 */

public class TicketFragment extends Fragment {


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
        View rootView = inflater.inflate(R.layout.fragment_ticket, container, false);

        return rootView;
    }
}
