package com.npelly.cloneme;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Obtain application context before any other Android lifecycle events.
 */
public class MainApplication extends Application {
    @Override
    public void onCreate(){
        super.onCreate();
        Base.createSingleton(this);
        Base.logd("MainApplication onCreate()");
        Base.logd("package: " + getPackageName() + " version: " + getVersionString());
    }

    private String getVersionString() {
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            return packageInfo.versionCode + " (" + packageInfo.versionName + ")";
        } catch (PackageManager.NameNotFoundException e) {
            return "<error>";
        }
    }
}
