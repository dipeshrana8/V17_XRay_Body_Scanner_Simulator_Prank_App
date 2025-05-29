package com.xrayscan.malebodyscanner.camera.simulatorapp.featureui;

import android.content.Intent;
import android.os.Bundle;

import com.xrayscan.malebodyscanner.camera.simulatorapp.R;
import com.xrayscan.malebodyscanner.camera.simulatorapp.databinding.LytAct4Binding;

public class BodyPartInfoActivity extends MainBaseActivity {

    private LytAct4Binding lytAct4Binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lytAct4Binding = LytAct4Binding.inflate(getLayoutInflater());
        setContentView(lytAct4Binding.getRoot());
        lytAct4Binding.toolbarLayout.headerTitle.setText("Explore Body Part");
        lytAct4Binding.toolbarLayout.btnBack.setOnClickListener(v -> onBackPressed());
        Intent intent = getIntent();

        int image = intent.getIntExtra("image", R.mipmap.logo);
        String description = intent.getStringExtra("description");
        String title = intent.getStringExtra("title");

        lytAct4Binding.imgBodyPart.setImageResource(image);
        lytAct4Binding.txtDescription.setText(description);
        lytAct4Binding.txtTitle.setText(title);

    }

    @Override
    public void onBackPressed() {
        handleBackNavigation();
    }
}