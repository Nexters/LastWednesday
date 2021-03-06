package com.teamnexters.lastwednesday;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.teamnexters.lastwednesday.activity.SplashActivity;
import com.teamnexters.lastwednesday.adapter.MainViewPagerAdapter;
import com.teamnexters.lastwednesday.custom.StuckViewPager;
import com.teamnexters.lastwednesday.fragment.anim.RevolvingPageTransformer;

public class MainActivity extends AppCompatActivity {

    Context mContext;
    StuckViewPager mViewPager;
    MainViewPagerAdapter mAdapter;
    boolean doubleBackToExitPressedOnce = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        startActivity(new Intent(mContext, SplashActivity.class));

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

    public void actionModeState(boolean state) { //액션모드가 진행중인지 검사
        mViewPager.setPageEnabled(!state);
    }


}
