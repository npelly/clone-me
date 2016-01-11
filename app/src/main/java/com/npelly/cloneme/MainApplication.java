package com.npelly.cloneme;

import android.app.Application;

/**
 * Obtain application context before any other Android lifecycle events.
 */
public class MainApplication extends Application {
    @Override
    public void onCreate(){
        super.onCreate();
        Base.createSingleton(this);
        Base.logd("MainApplication onCreate()");
    }
}
