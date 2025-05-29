package com.xrayscan.malebodyscanner.camera.simulatorapp.featureui;

import static android.view.View.GONE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.xrayscan.malebodyscanner.camera.simulatorapp.R;
import com.xrayscan.malebodyscanner.camera.simulatorapp.databinding.LytAct9Binding;

public class MainActivity extends MainBaseActivity {

    LytAct9Binding lytAct9Binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        topBarTitleText = getResources().getString(R.string.app_name);
        isBackVisible = false;

        super.onCreate(savedInstanceState);


        lytAct9Binding = LytAct9Binding.inflate(getLayoutInflater());
        setContentView(lytAct9Binding.getRoot());
        lytAct9Binding.toolbarLayout.headerTitle.setText("Full Xray Vision-Body scanner");
        lytAct9Binding.toolbarLayout.btnBack.setVisibility(GONE);

        lytAct9Binding.toolbarLayout.headerTitle.setSelected(true);
        lytAct9Binding.btnFullBodyScan.setOnClickListener(v -> {

            SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("category", "btnFullBodyScan");
            editor.apply();


            Intent intent = new Intent(MainActivity.this, GenderSelectionActivity.class);
            startActivity(intent);
        });

        lytAct9Binding.btnHumanSpecies.setOnClickListener(v -> {

            SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("category", "btnHumanSpecies");
            editor.apply();

            Intent intent = new Intent(MainActivity.this, GenderSelectionActivity.class);
            startActivity(intent);
        });

        lytAct9Binding.btnOldBody.setOnClickListener(v -> {

            SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("category", "btnOldBody");
            editor.apply();

            Intent intent = new Intent(MainActivity.this, GenderSelectionActivity.class);
            startActivity(intent);
        });

        lytAct9Binding.btnOpenGallery.setOnClickListener(v -> {

            SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("category", "btnOpenGallery");
            editor.apply();

            Intent intent = new Intent(MainActivity.this, GenderSelectionActivity.class);
            startActivity(intent);
        });


        lytAct9Binding.btnBodyPartName.setOnClickListener(v -> {

            SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("category", "btnBodyPartName");
            editor.apply();

            Intent intent = new Intent(MainActivity.this, GenderSelectionActivity.class);
            startActivity(intent);
        });

        lytAct9Binding.btnBodyFilter.setOnClickListener(v -> {

            SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("category", "btnBodyFilter");
            editor.apply();

            Intent intent = new Intent(MainActivity.this, GenderSelectionActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(MainActivity.this, ExitScreenActivity.class);
        startActivity(intent);


    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("IntroChecked", true);
        editor.apply();
    }

}