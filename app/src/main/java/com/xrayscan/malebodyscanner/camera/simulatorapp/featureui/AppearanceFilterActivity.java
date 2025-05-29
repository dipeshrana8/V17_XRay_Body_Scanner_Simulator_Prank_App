package com.xrayscan.malebodyscanner.camera.simulatorapp.featureui;

import static android.view.View.GONE;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.xrayscan.malebodyscanner.camera.simulatorapp.R;
import com.xrayscan.malebodyscanner.camera.simulatorapp.databinding.LytAct3Binding;

import java.util.LinkedHashMap;
import java.util.Map;

public class AppearanceFilterActivity extends MainBaseActivity {
    private static final int PICK_IMAGE_REQUEST = 1;
    LytAct3Binding lytAct3Binding;
    int selectedIndex = -1;
    private boolean isImageSelected = false;
    private boolean isDoneState = false;
    private String selectedSkinTone = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lytAct3Binding = LytAct3Binding.inflate(getLayoutInflater());
        setContentView(lytAct3Binding.getRoot());

        lytAct3Binding.toolbarLayout.headerTitle.setText("Select Skin Tone");
        lytAct3Binding.toolbarLayout.btnBack.setOnClickListener(v -> onBackPressed());

        setupSkinToneButtons();

        lytAct3Binding.btnNext.setOnClickListener(v -> {
            if (selectedIndex == -1) {
                Toast.makeText(this, "Please select a skin tone", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(AppearanceFilterActivity.this, BodyTypeSelectorActivity.class);
                intent.putExtra("selected_skin_index", selectedIndex);
                intent.putExtra("selected_skin_name", selectedSkinTone);
                startActivity(intent);
            }
        });


        lytAct3Binding.btnNext.setOnClickListener(v -> {

            if (!isImageSelected) {
                openGallery();
            } else if (!isDoneState) {

                isDoneState = true;
            } else {

                Intent intent = new Intent(AppearanceFilterActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri imageUri = data.getData();
            lytAct3Binding.imgPreview.setImageURI(imageUri);
            lytAct3Binding.btnNext.setVisibility(GONE);
            lytAct3Binding.toolbarLayout.headerTitle.setText("Image Preview");
            isDoneState = true;
            isImageSelected = true;
        }
    }

    private void setupSkinToneButtons() {
        Map<View, String> skinToneMap = new LinkedHashMap<>();
        Map<View, Integer> imageMap = new LinkedHashMap<>();

        skinToneMap.put(lytAct3Binding.btnFilter0, "Fair");
        skinToneMap.put(lytAct3Binding.btnFilter1, "Olive");
        skinToneMap.put(lytAct3Binding.btnFilter2, "Light");
        skinToneMap.put(lytAct3Binding.btnFilter3, "Brown");

        imageMap.put(lytAct3Binding.btnFilter0, R.drawable.img_x_image_32);
        imageMap.put(lytAct3Binding.btnFilter1, R.drawable.img_x_image_33);
        imageMap.put(lytAct3Binding.btnFilter2, R.drawable.img_x_image_35);
        imageMap.put(lytAct3Binding.btnFilter3, R.drawable.img_x_image_35);

        int[] index = {0};
        for (Map.Entry<View, String> entry : skinToneMap.entrySet()) {
            View button = entry.getKey();
            String skinTone = entry.getValue();
            final int currentIndex = index[0];

            button.setOnClickListener(v -> {
                selectedIndex = currentIndex;
                selectedSkinTone = skinTone;
                updateSelectedUI(skinToneMap, button);


                lytAct3Binding.imgPreview.setImageResource(imageMap.get(button));
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