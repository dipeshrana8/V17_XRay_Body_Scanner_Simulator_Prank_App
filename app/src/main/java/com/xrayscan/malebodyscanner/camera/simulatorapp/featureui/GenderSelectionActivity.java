package com.xrayscan.malebodyscanner.camera.simulatorapp.featureui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.xrayscan.malebodyscanner.camera.simulatorapp.R;
import com.xrayscan.malebodyscanner.camera.simulatorapp.databinding.LytAct10Binding;

public class GenderSelectionActivity extends MainBaseActivity {

    private LytAct10Binding lytAct10Binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lytAct10Binding = LytAct10Binding.inflate(getLayoutInflater());
        setContentView(lytAct10Binding.getRoot());


        setupGenderButtons();

        lytAct10Binding.toolbarLayout.headerTitle.setText("Select Age & Gender");
        lytAct10Binding.toolbarLayout.btnBack.setOnClickListener(v -> handleBackNavigation());

        lytAct10Binding.btnConfirm.setOnClickListener(v -> {


            SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
            String name = sharedPreferences.getString("category", "");


            if (name.equals("btnFullBodyScan")) {

                Intent intent = new Intent(GenderSelectionActivity.this, SelectAgeActivity.class);
                startActivity(intent);
            } else if (name.equals("btnOldBody")) {

                Intent intent = new Intent(GenderSelectionActivity.this, SelectAgeActivity.class);
                startActivity(intent);
            } else if (name.equals("btnBodyPartName")) {

                Intent intent = new Intent(GenderSelectionActivity.this, BodyExplorerActivity.class);
                startActivity(intent);
            } else if (name.equals("btnBodyFilter")) {

                Intent intent = new Intent(GenderSelectionActivity.this, SelectAgeActivity.class);
                startActivity(intent);
            } else if (name.equals("btnHumanSpecies")) {

                Intent intent = new Intent(GenderSelectionActivity.this, SpeciesInfoActivity.class);
                startActivity(intent);
            } else if (name.equals("btnOpenGallery")) {

                Intent intent = new Intent(GenderSelectionActivity.this, ImageUploadActivity.class);
                startActivity(intent);
            }
        });
    }


    private void setupGenderButtons() {


        lytAct10Binding.btnMale.setOnClickListener(v -> {
            lytAct10Binding.btnMale.setBackgroundResource(R.drawable.img_x_image_4);
            lytAct10Binding.btnFemale.setBackgroundResource(R.drawable.img_x_image_5);
            lytAct10Binding.btnOthers.setBackgroundResource(R.drawable.img_x_image_5);
        });

        lytAct10Binding.btnFemale.setOnClickListener(v -> {
            lytAct10Binding.btnFemale.setBackgroundResource(R.drawable.img_x_image_4);
            lytAct10Binding.btnMale.setBackgroundResource(R.drawable.img_x_image_5);
            lytAct10Binding.btnOthers.setBackgroundResource(R.drawable.img_x_image_5);
        });
        lytAct10Binding.btnOthers.setOnClickListener(v -> {
            lytAct10Binding.btnOthers.setBackgroundResource(R.drawable.img_x_image_4);
            lytAct10Binding.btnMale.setBackgroundResource(R.drawable.img_x_image_5);
            lytAct10Binding.btnFemale.setBackgroundResource(R.drawable.img_x_image_5);

        });
    }


    @Override
    public void onBackPressed() {
        handleBackNavigation();
    }
}