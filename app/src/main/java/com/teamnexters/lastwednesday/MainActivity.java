package com.teamnexters.lastwednesday;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.teamnexters.lastwednesday.adapter.MainViewPagerAdapter;
import com.teamnexters.lastwednesday.fragment.anim.RevolvingPageTransformer;

public class MainActivity extends AppCompatActivity {

    Context mContext;
    ViewPager mViewPager;
    MainViewPagerAdapter mAdapter;
    boolean doubleBackToExitPressedOnce = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(mContext);

        mAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
        mViewPager = findViewById(R.id.viewpager_main);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setCurrentItem(1);
        mViewPager.setPageTransformer(true, new RevolvingPageTransformer());
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "뒤로 버튼을 한번 더 누르시면 종료됩니다", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }


}
