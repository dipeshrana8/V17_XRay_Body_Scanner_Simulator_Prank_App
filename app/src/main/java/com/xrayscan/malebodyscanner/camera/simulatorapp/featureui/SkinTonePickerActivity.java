package com.xrayscan.malebodyscanner.camera.simulatorapp.featureui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.xrayscan.malebodyscanner.camera.simulatorapp.R;
import com.xrayscan.malebodyscanner.camera.simulatorapp.databinding.LytAct21Binding;

import java.util.LinkedHashMap;
import java.util.Map;


public class SkinTonePickerActivity extends MainBaseActivity {

    LytAct21Binding lytAct21Binding;
    int selectedIndex = -1;
    private String selectedSkinTone = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lytAct21Binding = LytAct21Binding.inflate(getLayoutInflater());
        setContentView(lytAct21Binding.getRoot());

        lytAct21Binding.toolbarLayout.headerTitle.setText("Select Skin Tone");
        lytAct21Binding.toolbarLayout.btnBack.setOnClickListener(v -> onBackPressed());

        setupSkinToneButtons();

        lytAct21Binding.btnNext.setOnClickListener(v -> {
            SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
            String name = sharedPreferences.getString("category", "");


            if (name.equals("btnFullBodyScan")) {

                Intent intent = new Intent(SkinTonePickerActivity.this, BodyTypeSelectorActivity.class);
                startActivity(intent);
            } else if (name.equals("btnOldBody")) {

                Intent intent = new Intent(SkinTonePickerActivity.this, ImageUploadActivity.class);
                startActivity(intent);
            } else if (name.equals("btnBodyPartName")) {

                Intent intent = new Intent(SkinTonePickerActivity.this, BodyExplorerActivity.class);
                startActivity(intent);
            } else if (name.equals("btnBodyFilter")) {

                Intent intent = new Intent(SkinTonePickerActivity.this, AppearanceFilterActivity.class);
                startActivity(intent);
            } else if (name.equals("btnHumanSpecies")) {

                Intent intent = new Intent(SkinTonePickerActivity.this, SpeciesInfoActivity.class);
                startActivity(intent);
            } else if (name.equals("btnOpenGallery")) {

                Intent intent = new Intent(SkinTonePickerActivity.this, SkinToneInfoActivity.class);
                startActivity(intent);
            }


        });
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("skinTone", "Fair");
    }

    private void setupSkinToneButtons() {
        Map<View, String> skinToneMap = new LinkedHashMap<>();
        skinToneMap.put(lytAct21Binding.btnFair, "Fair");
        skinToneMap.put(lytAct21Binding.btnOlive, "Olive");
        skinToneMap.put(lytAct21Binding.btnLight, "Light");
        skinToneMap.put(lytAct21Binding.btnBrown, "Brown");
        skinToneMap.put(lytAct21Binding.btnBlack, "Black");

        int[] index = {0};
        for (Map.Entry<View, String> entry : skinToneMap.entrySet()) {
            View button = entry.getKey();
            String skinTone = entry.getValue();
            final int currentIndex = index[0];

            button.setOnClickListener(v -> {
                selectedIndex = currentIndex;
                selectedSkinTone = skinTone;

                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("skinTone", selectedSkinTone);
                editor.apply();

                updateSelectedUI(skinToneMap, button);
            });

            index[0]++;
        }
    }

    private void updateSelectedUI(Map<View, String> skinToneMap, View selectedButton) {
        for (View button : skinToneMap.keySet()) {
            if (button == selectedButton) {
                button.setBackgroundResource(R.drawable.img_x_image_4);
            } else {
                button.setBackgroundResource(R.drawable.img_x_image_5);
            }
        }
    }

    @Override
    public void onBackPressed() {
        handleBackNavigation();
    }
}
