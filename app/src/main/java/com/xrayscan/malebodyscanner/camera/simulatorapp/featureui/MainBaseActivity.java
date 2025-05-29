package com.xrayscan.malebodyscanner.camera.simulatorapp.featureui;

import android.content.Intent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.xrayscan.malebodyscanner.camera.simulatorapp.R;
import com.xrayscan.malebodyscanner.camera.simulatorapp.core.InAppAdLoader;
import com.xrayscan.malebodyscanner.camera.simulatorapp.core.WebRedirectHelper;


public class MainBaseActivity extends AppCompatActivity {

    protected boolean isBackVisible = true;
    protected boolean isSettingsEnabled = true;
    protected String topBarTitleText = "XRay Body Scanner Simulator - Prank App";
    protected boolean enableEmbeddedAds = true;
    protected boolean enableTransitionAd = true;
    protected boolean enableBackAdTrigger = true;

    private FrameLayout adDisplayHolder;


    protected void initializeTopBar(TextView headerTextView, @Nullable View backsBtn, @Nullable View settingsBtn) {

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(isBackVisible);
        }

        if (headerTextView != null) {
            headerTextView.setText(topBarTitleText);
            headerTextView.setSelected(true);
        }


        if (backsBtn != null) {
            backsBtn.setVisibility(isBackVisible ? View.VISIBLE : View.INVISIBLE);

        }
    }


    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        if (enableTransitionAd) {
            WebRedirectHelper.WebInterstitial(this);
        }

        overridePendingTransition(0, 0);
    }


    protected void handleBackNavigation() {

        if (enableBackAdTrigger) {
            WebRedirectHelper.WebInterstitial(this);
        }
        finish();
        overridePendingTransition(0, 0);
    }


    @Override
    protected void onResume() {
        super.onResume();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        renderNativeAdContent();
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        prepareAdContainer();
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        prepareAdContainer();
    }

    private void prepareAdContainer() {
        try {

            adDisplayHolder = findViewById(R.id.previewFrameHolder);
        } catch (Exception e) {
            adDisplayHolder = null;
        }
    }

    protected void renderNativeAdContent() {
        if (enableEmbeddedAds && adDisplayHolder != null) {
            InAppAdLoader.NativeClass(adDisplayHolder, this);
            adDisplayHolder.setVisibility(View.VISIBLE);
        } else if (adDisplayHolder != null) {
            adDisplayHolder.setVisibility(View.GONE);
        }
    }


}
