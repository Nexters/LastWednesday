package com.teamnexters.lastwednesday.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.teamnexters.lastwednesday.R;
import com.teamnexters.lastwednesday.activity.LogInActivity;
import com.teamnexters.lastwednesday.activity.SearchActivity;
import com.teamnexters.lastwednesday.databinding.FragmentMainBinding;

/**
 * Created by JY on 2018-01-10.
 * <p>
 * Edited by Hyunsik on 2018-01-11.
 */

public class MainFragment extends Fragment implements GoogleApiClient.OnConnectionFailedListener, View.OnClickListener {

    FragmentMainBinding binding;

    private GoogleApiClient googleApiClient;
    private Button SignOut;

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        View rootView = binding.getRoot();
        binding.setMain(this);


        GoogleSignInOptions signInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleApiClient = new GoogleApiClient.Builder(getActivity()).addApi(Auth.GOOGLE_SIGN_IN_API, signInOptions).build();
        googleApiClient.connect();
        SignOut = rootView.findViewById(R.id.btn_logout);
        SignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLogoutPressed();
            }
        });
        return rootView;
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    public void onLogoutPressed() {
        new AlertDialog.Builder(getActivity()).setTitle("Exit").setMessage("로그아웃 하시겠습니까?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Auth.GoogleSignInApi.signOut(googleApiClient);
                        Intent intent = new Intent(getActivity(), LogInActivity.class);
                        MainFragment.this.startActivity(intent);
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }).show();
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(), SearchActivity.class);
        startActivity(intent);
    }


}

