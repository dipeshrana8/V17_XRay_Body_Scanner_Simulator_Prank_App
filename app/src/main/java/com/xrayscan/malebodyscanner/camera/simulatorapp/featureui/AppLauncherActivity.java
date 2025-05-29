package com.xrayscan.malebodyscanner.camera.simulatorapp.featureui;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.DecelerateInterpolator;

import com.onesignal.Continue;
import com.onesignal.OneSignal;
import com.onesignal.debug.LogLevel;
import com.xrayscan.malebodyscanner.camera.simulatorapp.core.AdPreferencesManager;
import com.xrayscan.malebodyscanner.camera.simulatorapp.databinding.LytAct13Binding;


public class AppLauncherActivity extends MainBaseActivity {

    LytAct13Binding lytAct13Binding;
    private boolean IntroChecked = false;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        enableEmbeddedAds = false;
        enableTransitionAd = true;
        super.onCreate(savedInstanceState);
        lytAct13Binding = LytAct13Binding.inflate(getLayoutInflater());
        setContentView(lytAct13Binding.getRoot());


        ObjectAnimator animation = ObjectAnimator.ofInt(lytAct13Binding.progressBar, "progress", 0, 100);
        animation.setDuration(3000);
        animation.setInterpolator(new DecelerateInterpolator());
        animation.start();

        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        prefs.edit().putBoolean("spin_dialog_shown", false).apply();

        preferences = getSharedPreferences("FfPref", MODE_PRIVATE);
        IntroChecked = preferences.getBoolean("IntroChecked", false);


        OneSignal.getDebug().setLogLevel(LogLevel.VERBOSE);


        String oneSignalAppId = AdPreferencesManager.getOneSignalAppId();
        if (!oneSignalAppId.isEmpty()) {
            OneSignal.initWithContext(this, oneSignalAppId);


            OneSignal.getNotifications().requestPermission(false, Continue.none());
        }

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            if (IntroChecked) {

                startActivity(new Intent(AppLauncherActivity.this, MainActivity.class));
                finish();
            } else {

                startActivity(new Intent(AppLauncherActivity.this, SelectCountryActivity.class));
                finish();
            }
        }, 3500);
    }
}
