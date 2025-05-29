package com.xrayscan.malebodyscanner.camera.simulatorapp.featureui;

import static android.view.View.GONE;

import android.os.Bundle;

import com.xrayscan.malebodyscanner.camera.simulatorapp.databinding.LytAct8Binding;

public class ExitScreenActivity extends MainBaseActivity {

    LytAct8Binding lytAct8Binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        topBarTitleText = "Are Sure to Exit?";
        isSettingsEnabled = true;
        super.onCreate(savedInstanceState);
        lytAct8Binding = LytAct8Binding.inflate(getLayoutInflater());
        setContentView(lytAct8Binding.getRoot());
        initializeTopBar(
                lytAct8Binding.toolbarLayout.headerTitle,
                lytAct8Binding.toolbarLayout.btnBack,
                lytAct8Binding.toolbarLayout.btnSettings
        );
        lytAct8Binding.toolbarLayout.btnBack.setVisibility(GONE);
        lytAct8Binding.toolbarLayout.btnBack.setOnClickListener(v -> onBackPressed());
        initializeTopBar(lytAct8Binding.toolbarLayout.headerTitle, lytAct8Binding.toolbarLayout.btnBack, lytAct8Binding.toolbarLayout.btnSettings);

        lytAct8Binding.btnYes.setOnClickListener(v -> {
            finishAffinity();
        });


        lytAct8Binding.btnNo.setOnClickListener(v -> {

            handleBackNavigation();
        });

    }

    @Override
    public void onBackPressed() {
        handleBackNavigation();
    }
}