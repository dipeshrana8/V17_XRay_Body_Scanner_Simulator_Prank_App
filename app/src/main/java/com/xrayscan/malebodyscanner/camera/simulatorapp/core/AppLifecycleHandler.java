package com.xrayscan.malebodyscanner.camera.simulatorapp.core;

import android.app.Application;

public class AppLifecycleHandler extends Application {

    public static AppLifecycleHandler myController;

    public static AppLifecycleHandler get() {
        return myController;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myController = this;

    }
}
