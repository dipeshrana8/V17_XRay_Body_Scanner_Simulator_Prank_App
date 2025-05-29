package com.xrayscan.malebodyscanner.camera.simulatorapp.featureui;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.xrayscan.malebodyscanner.camera.simulatorapp.R;
import com.xrayscan.malebodyscanner.camera.simulatorapp.databinding.LytAct17Binding;

public class SkinToneInfoActivity extends MainBaseActivity {

    LytAct17Binding lytAct17Binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lytAct17Binding = LytAct17Binding.inflate(getLayoutInflater());
        setContentView(lytAct17Binding.getRoot());

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String url = sharedPreferences.getString("uri", "");

        if (!url.isEmpty()) {
            try {
                Uri uri = Uri.parse(url);
                lytAct17Binding.btnAddImage.setImageURI(uri);
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(this, "Image could not be loaded.", Toast.LENGTH_SHORT).show();
            }
        }

        String skinTone = sharedPreferences.getString("skinTone", "Fair");
        switch (skinTone) {
            case "Fair":
                lytAct17Binding.imgDot.setImageResource(R.drawable.img_x_image_47);
                lytAct17Binding.imgTxtPreview.setImageResource(R.drawable.img_x_image_48);
                break;
            case "Olive":
                lytAct17Binding.imgDot.setImageResource(R.drawable.img_x_image_70);
                lytAct17Binding.imgTxtPreview.setImageResource(R.drawable.img_x_image_71);
                break;
            case "Light":
                lytAct17Binding.imgDot.setImageResource(R.drawable.img_x_image_61);
                lytAct17Binding.imgTxtPreview.setImageResource(R.drawable.img_x_image_62);
                break;
            case "Brown":
                lytAct17Binding.imgDot.setImageResource(R.drawable.img_x_image_40);
                lytAct17Binding.imgTxtPreview.setImageResource(R.drawable.img_x_image_41);
                break;
            case "Black":
                lytAct17Binding.imgDot.setImageResource(R.drawable.img_x_image_29);
                lytAct17Binding.imgTxtPreview.setImageResource(R.drawable.img_x_image_31);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        handleBackNavigation();
    }
}