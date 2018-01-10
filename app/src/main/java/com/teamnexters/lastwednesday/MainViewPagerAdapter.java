package com.teamnexters.lastwednesday;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.teamnexters.lastwednesday.Fragment.HistoryFragment;
import com.teamnexters.lastwednesday.Fragment.MainFragment;
import com.teamnexters.lastwednesday.Fragment.TicketFragment;

/**
 * Created by JY on 2018-01-10.
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
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
