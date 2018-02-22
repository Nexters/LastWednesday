package com.teamnexters.lastwednesday.model;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.teamnexters.lastwednesday.R;
import com.teamnexters.lastwednesday.activity.RecentSearchActivity;

/**
 * Created by user on 2018-02-10.
 */
/**
public class PlaySearchDialog extends Activity {
    public ImageView mDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_forthisplay);

        mDialog = findViewById(R.id.recentplayposter);
        mDialog.setClickable(true);

        mDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
*/