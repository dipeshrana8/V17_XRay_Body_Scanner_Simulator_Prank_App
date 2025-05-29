package com.xrayscan.malebodyscanner.camera.simulatorapp.featureui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.xrayscan.malebodyscanner.camera.simulatorapp.R;
import com.xrayscan.malebodyscanner.camera.simulatorapp.databinding.LytAct1Binding;

public class ImageUploadActivity extends MainBaseActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    private LytAct1Binding lytAct1Binding;
    private boolean isImageSelected = false;
    private boolean isDoneState = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lytAct1Binding = LytAct1Binding.inflate(getLayoutInflater());
        setContentView(lytAct1Binding.getRoot());

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String name = sharedPreferences.getString("category", "");

        if (name.equals("Body Scanner")) {
            lytAct1Binding.toolbarLayout.headerTitle.setText("Add Image");
        } else if (name.equals("btnOldBody")) {
            lytAct1Binding.toolbarLayout.headerTitle.setText("Your Old Body");
        } else if (name.equals("btnOpenGallery")) {
            lytAct1Binding.toolbarLayout.headerTitle.setText("Body Scanner");
        } else if (name.equals("btnBodyFilter")) {
            lytAct1Binding.toolbarLayout.headerTitle.setText("Body Filter");
        }

        lytAct1Binding.btnNextToGo.setOnClickListener(v -> {
            if (name.equals("btnOpenGallery")) {
                startActivity(new Intent(this, SkinTonePickerActivity.class));
                finish();
            } else if (name.equals("btnOldBody")) {
                startActivity(new Intent(this, SkinToneInfoActivity.class));
                finish();
            }
        });

        lytAct1Binding.toolbarLayout.btnBack.setOnClickListener(v -> onBackPressed());

        lytAct1Binding.btnNext.setOnClickListener(v -> {
            if (!isImageSelected) {
                openGallery();
            } else if (!isDoneState) {
                isDoneState = true;
            } else {
                startActivity(new Intent(this, MainActivity.class));
                finish();
            }
        });
    }

    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.setType("image/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri imageUri = data.getData();


            final int takeFlags = data.getFlags() & Intent.FLAG_GRANT_READ_URI_PERMISSION;
            getContentResolver().takePersistableUriPermission(imageUri, takeFlags);


            lytAct1Binding.btnAddImage.setImageURI(imageUri);
            lytAct1Binding.imgTxtPreview.setImageResource(R.drawable.img_x_image_23);
            lytAct1Binding.toolbarLayout.headerTitle.setText("Image Preview");


            SharedPreferences.Editor editor = getSharedPreferences("MyPrefs", MODE_PRIVATE).edit();
            editor.putString("uri", imageUri.toString());
            editor.apply();


            String name = getSharedPreferences("MyPrefs", MODE_PRIVATE).getString("category", "");
            if (name.equals("btnOpenGallery") || name.equals("btnOldBody")) {
                lytAct1Binding.btnNextToGo.setVisibility(View.VISIBLE);
                lytAct1Binding.btnNext.setVisibility(View.GONE);
            }
            if (name.equals("btnFullBodyScan")) {
                lytAct1Binding.btnNext.setVisibility(View.GONE);
            }


            isDoneState = true;
            isImageSelected = true;
        }
    }

    @Override
    public void onBackPressed() {
        handleBackNavigation();
    }
}