package com.android.androidcomponents;


import android.app.Application;

import com.android.androidcomponents.injection.DaggerCountdownComponent;
import com.jakewharton.threetenabp.AndroidThreeTen;

import timber.log.Timber;
import com.android.androidcomponents.injection.CountdownComponent;
import com.android.androidcomponents.injection.CountdownModule;

public class CountdownApplication extends Application {

    private final CountdownComponent countDownComponent = createCountdownComponent();

    @Override
    public void onCreate() {
        super.onCreate();
        AndroidThreeTen.init(this);
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());//TODO Install a Crashlytics tree in production
        }
    }

    protected CountdownComponent createCountdownComponent() {
        return DaggerCountdownComponent.builder()
                .countdownModule(new CountdownModule(this))
                .build();
    }

    public CountdownComponent getCountDownComponent() {
        return countDownComponent;
    }

}
