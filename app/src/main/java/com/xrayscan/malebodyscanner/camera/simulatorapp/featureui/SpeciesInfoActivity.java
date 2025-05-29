package com.xrayscan.malebodyscanner.camera.simulatorapp.featureui;

import android.os.Bundle;
import android.view.View;

import com.xrayscan.malebodyscanner.camera.simulatorapp.databinding.LytAct5Binding;

public class SpeciesInfoActivity extends MainBaseActivity {


    LytAct5Binding lytAct5Binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lytAct5Binding = LytAct5Binding.inflate(getLayoutInflater());
        setContentView(lytAct5Binding.getRoot());

        lytAct5Binding.toolbarLayout.headerTitle.setText("Human Species");
        lytAct5Binding.toolbarLayout.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleBackNavigation();
            }
        });
    }

    @Override
    public void onBackPressed() {
        handleBackNavigation();
    }
}