package com.teamnexters.lastwednesday.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.teamnexters.lastwednesday.MainActivity;
import com.teamnexters.lastwednesday.R;

/**
 * Created by user on 2018-01-11.
 */

public class LogInActivity extends AppCompatActivity implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener {

    private SignInButton btn_google;
    private GoogleApiClient googleApiClient;
    private static final int REQ_CODE = 9001;
    private LoginButton btn_facebook;
    CallbackManager callbackManager;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mContext = this;

        callbackManager = CallbackManager.Factory.create();

        //google
        btn_google = (SignInButton) findViewById(R.id.btn_google);
        btn_google.setOnClickListener(this);
        TextView textView = (TextView) btn_google.getChildAt(0);
        textView.setText("Sign in with Google");
        GoogleSignInOptions signInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleApiClient = new GoogleApiClient.Builder(mContext)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, signInOptions).build();


        //facebook
        btn_facebook = (LoginButton) findViewById(R.id.btn_facebook);
        //btn_facebook.setReadPermissions("email"); 이메일 필요하면 넣기
        btn_facebook.setOnClickListener(this);

        // Callback registration
        btn_facebook.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
                Log.e("@@@@@", "1111111");
                finish();
                startActivity(new Intent(mContext, MainActivity.class));
            }

            @Override
            public void onCancel() {
                // App code
                Log.e("@@@@@", "22222222");
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
                Log.e("@@@@@", "33333333");
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_google:
                signIn();
                break;
            case R.id.btn_facebook:
                Log.e("@@@@@", "444444444");
                //딱히 정의할 필요 없는 부분
                break;
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    }

    private void signIn() {
        Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        startActivityForResult(intent, REQ_CODE);
    }


    private void handleResult(GoogleSignInResult result) {
        if (result.isSuccess()) {
            GoogleSignInAccount account = result.getSignInAccount();
            Intent intent = new Intent(LogInActivity.this, MainActivity.class); //이렇게 만들어야하는가?
            LogInActivity.this.startActivity(intent);
            finish();
        } else {
            btn_google.setVisibility(View.VISIBLE);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQ_CODE) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleResult(result);
        }
    }
}
