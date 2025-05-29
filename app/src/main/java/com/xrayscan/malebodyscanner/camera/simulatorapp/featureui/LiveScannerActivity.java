package com.xrayscan.malebodyscanner.camera.simulatorapp.featureui;

import android.content.Intent;
import android.os.Bundle;

import com.xrayscan.malebodyscanner.camera.simulatorapp.R;
import com.xrayscan.malebodyscanner.camera.simulatorapp.databinding.LytAct19Binding;

public class LiveScannerActivity extends MainBaseActivity {

    LytAct19Binding lytAct19Binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lytAct19Binding = LytAct19Binding.inflate(getLayoutInflater());
        setContentView(lytAct19Binding.getRoot());
        lytAct19Binding.txtDescription.setText("Body Camera Scanner");
        lytAct19Binding.imgChange.setImageResource(R.drawable.img_x_image_42);

        lytAct19Binding.btnNext.setOnClickListener(v -> {

            Intent intent = new Intent(LiveScannerActivity.this, XrayPreviewActivity.class);
            startActivity(intent);
        });


    }

    @Override
    public void onBackPressed() {
        handleBackNavigation();
    }
}