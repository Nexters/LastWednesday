package com.teamnexters.lastwednesday;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.teamnexters.lastwednesday.activity.LogInActivity;
import com.teamnexters.lastwednesday.adapter.MainViewPagerAdapter;

public class MainActivity extends AppCompatActivity implements  GoogleApiClient.OnConnectionFailedListener{

    Context mContext;
    ViewPager mViewPager;
    MainViewPagerAdapter mAdapter;
    private GoogleApiClient googleApiClient;
    private Button SignOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GoogleSignInOptions signInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleApiClient = new GoogleApiClient.Builder(this).enableAutoManage(this,this).addApi(Auth.GOOGLE_SIGN_IN_API,signInOptions).build();

        SignOut = (Button) findViewById(R.id.bn_logout);
        SignOut.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
               Auth.GoogleSignInApi.signOut(googleApiClient);
                Intent intent = new Intent(MainActivity.this, LogInActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        mContext = this;
        mAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.viewpager_main);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setCurrentItem(1);
    }


    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    }

}
