package com.teamnexters.lastwednesday;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.teamnexters.lastwednesday.adapter.MainViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    Context mContext;
    ViewPager mViewPager;
    MainViewPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mContext = this;


        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(mContext);

        mAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.viewpager_main);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setCurrentItem(1);
    }


}
