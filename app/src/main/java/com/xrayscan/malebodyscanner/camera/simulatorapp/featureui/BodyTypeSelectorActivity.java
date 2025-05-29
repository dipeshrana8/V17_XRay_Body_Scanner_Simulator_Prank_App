package com.xrayscan.malebodyscanner.camera.simulatorapp.featureui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.xrayscan.malebodyscanner.camera.simulatorapp.R;
import com.xrayscan.malebodyscanner.camera.simulatorapp.databinding.LytAct20Binding;

public class BodyTypeSelectorActivity extends MainBaseActivity {
    private LytAct20Binding lytAct20Binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        topBarTitleText = "Select Body Type";
        super.onCreate(savedInstanceState);


        lytAct20Binding = LytAct20Binding.inflate(getLayoutInflater());
        setContentView(lytAct20Binding.getRoot());

        isSettingsEnabled = true;

        lytAct20Binding.toolbarLayout.headerTitle.setText("Select Body Type");
        lytAct20Binding.toolbarLayout.btnBack.setOnClickListener(v -> onBackPressed());

        lytAct20Binding.btnUpperBody.setOnClickListener(v -> {

            lytAct20Binding.imgChange.setImageResource(R.drawable.img_x_image_84);
            lytAct20Binding.imgBtn.setImageResource(R.drawable.img_x_image_85);
        });

        lytAct20Binding.btnLowerBody.setOnClickListener(v -> {
            lytAct20Binding.imgChange.setImageResource(R.drawable.img_x_image_88);
            lytAct20Binding.imgBtn.setImageResource(R.drawable.img_x_image_90);
        });

        lytAct20Binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                String name = sharedPreferences.getString("category", "");
                if (name.equals("btnFullBodyScan")) {

                    Intent intent = new Intent(BodyTypeSelectorActivity.this, ImageUploadActivity.class);
                    startActivity(intent);
                }
            }
        });
    }


    @Override
    public void onBackPressed() {
        handleBackNavigation();
    }

}