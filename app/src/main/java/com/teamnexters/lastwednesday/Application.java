package com.teamnexters.lastwednesday;

import com.facebook.stetho.Stetho;

/**
 * Created by JY on 2018-01-31.
 */

public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
