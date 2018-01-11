package com.teamnexters.lastwednesday.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.teamnexters.lastwednesday.fragment.HistoryFragment;
import com.teamnexters.lastwednesday.fragment.MainFragment;
import com.teamnexters.lastwednesday.fragment.TicketFragment;

/**
 * Created by JY on 2018-01-10.
 *
 * Edited by Hyunsik on 2018-01-11.
 */

public class MainViewPagerAdapter extends FragmentPagerAdapter {


    public MainViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return TicketFragment.newInstance();
            case 1:
                return MainFragment.newInstance();
            case 2:
                return HistoryFragment.newInstance();
            default:
                return  MainFragment.newInstance();

        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
