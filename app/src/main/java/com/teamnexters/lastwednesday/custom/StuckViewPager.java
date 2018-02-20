package com.teamnexters.lastwednesday.custom;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by JY on 2018-02-20.
 */

public class StuckViewPager extends ViewPager {

    private boolean isPageEnabled = true;

    public StuckViewPager ( @NonNull Context context ) {
        super(context);
    }

    public StuckViewPager ( @NonNull Context context, @Nullable AttributeSet attrs ) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent ( MotionEvent ev ) {
        return this.isPageEnabled && super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent ( MotionEvent ev ) {
        return this.isPageEnabled && super.onTouchEvent(ev);
    }

    public void setPageEnabled ( boolean pageEnabled ) {
        isPageEnabled = pageEnabled;
    }
}
