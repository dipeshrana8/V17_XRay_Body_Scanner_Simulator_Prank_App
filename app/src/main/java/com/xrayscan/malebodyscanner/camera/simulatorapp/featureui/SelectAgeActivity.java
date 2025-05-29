package com.xrayscan.malebodyscanner.camera.simulatorapp.featureui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.xrayscan.malebodyscanner.camera.simulatorapp.R;
import com.xrayscan.malebodyscanner.camera.simulatorapp.databinding.LytAct2Binding;
import com.xrayscan.malebodyscanner.camera.simulatorapp.entry.AgeSelectorAdapter;

import java.util.ArrayList;
import java.util.List;

public class SelectAgeActivity extends MainBaseActivity {

    private final List<Integer> ageList = new ArrayList<>();
    private LytAct2Binding lytAct2Binding;
    private AgeSelectorAdapter ageSelectorAdapter;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lytAct2Binding = LytAct2Binding.inflate(getLayoutInflater());
        setContentView(lytAct2Binding.getRoot());

        for (int i = 10; i <= 70; i += 5) {
            ageList.add(i);
        }

        linearLayoutManager = new LinearLayoutManager(this);
        lytAct2Binding.recyclerView.setLayoutManager(linearLayoutManager);
        ageSelectorAdapter = new AgeSelectorAdapter(ageList);
        lytAct2Binding.recyclerView.setAdapter(ageSelectorAdapter);


        int selectedIndex = ageList.indexOf(25);
        ageSelectorAdapter.setSelectedIndex(selectedIndex);
        lytAct2Binding.recyclerView.scrollToPosition(selectedIndex);

        lytAct2Binding.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    View centerView = getCenterView(linearLayoutManager);
                    if (centerView != null) {
                        int centerPos = lytAct2Binding.recyclerView.getChildAdapterPosition(centerView);
                        ageSelectorAdapter.setSelectedIndex(centerPos);
                    }
                }
            }
        });


        SharedPreferences sharedPreferences1 = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String name1 = sharedPreferences1.getString("category", "");


        if (name1.equals("btnOldBody")) {
            lytAct2Binding.imgOld.setImageResource(R.drawable.img_x_image_74);
        } else {
            lytAct2Binding.imgOld.setImageResource(R.drawable.img_x_image_87);
        }


        lytAct2Binding.btnConfirm.setOnClickListener(v -> {


            SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
            String name = sharedPreferences.getString("category", "");


            if (name.equals("btnFullBodyScan")) {

                Intent intent = new Intent(SelectAgeActivity.this, SkinTonePickerActivity.class);
                startActivity(intent);
            } else if (name.equals("btnOldBody")) {

                Intent intent = new Intent(SelectAgeActivity.this, SkinTonePickerActivity.class);
                startActivity(intent);
            } else if (name.equals("btnBodyPartName")) {

                Intent intent = new Intent(SelectAgeActivity.this, BodyExplorerActivity.class);
                startActivity(intent);
            } else if (name.equals("btnBodyFilter")) {

                Intent intent = new Intent(SelectAgeActivity.this, SkinTonePickerActivity.class);
                startActivity(intent);
            } else if (name.equals("btnHumanSpecies")) {

                Intent intent = new Intent(SelectAgeActivity.this, SpeciesInfoActivity.class);
                startActivity(intent);
            }


        });
    }


    private View getCenterView(LinearLayoutManager layoutManager) {
        int center = lytAct2Binding.recyclerView.getHeight() / 2;
        int minDistance = Integer.MAX_VALUE;
        View closestView = null;

        for (int i = 0; i < lytAct2Binding.recyclerView.getChildCount(); i++) {
            View child = lytAct2Binding.recyclerView.getChildAt(i);
            int childCenter = (child.getTop() + child.getBottom()) / 2;
            int distance = Math.abs(childCenter - center);
            if (distance < minDistance) {
                minDistance = distance;
                closestView = child;
            }
        }
        return closestView;
    }


    @Override
    public void onBackPressed() {
        handleBackNavigation();
    }
}