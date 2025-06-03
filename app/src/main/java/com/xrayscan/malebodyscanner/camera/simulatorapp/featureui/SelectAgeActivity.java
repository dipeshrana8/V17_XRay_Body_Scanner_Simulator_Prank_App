package com.xrayscan.malebodyscanner.camera.simulatorapp.featureui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

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
    private final SnapHelper snapHelper = new LinearSnapHelper();
    private int selectedIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lytAct2Binding = LytAct2Binding.inflate(getLayoutInflater());
        setContentView(lytAct2Binding.getRoot());

        // Populate age list (10 to 100 with step 5)
        for (int i = 10; i <= 100; i += 5) {
            ageList.add(i);
        }

        // Setup RecyclerView
        linearLayoutManager = new LinearLayoutManager(this);
        lytAct2Binding.recyclerView.setLayoutManager(linearLayoutManager);
        ageSelectorAdapter = new AgeSelectorAdapter(ageList);
        lytAct2Binding.recyclerView.setAdapter(ageSelectorAdapter);

        // Add vertical padding to center selected item
        lytAct2Binding.recyclerView.setPadding(0, 300, 0, 300);
        lytAct2Binding.recyclerView.setClipToPadding(false);

        // Attach SnapHelper for centering
        snapHelper.attachToRecyclerView(lytAct2Binding.recyclerView);

        // Scroll to age 100 initially
        selectedIndex = ageList.indexOf(100);
        ageSelectorAdapter.setSelectedIndex(selectedIndex);
        lytAct2Binding.recyclerView.scrollToPosition(selectedIndex);

        // Listen for snap to detect center item
        lytAct2Binding.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    View centerView = snapHelper.findSnapView(linearLayoutManager); // ✅ fixed
                    if (centerView != null) {
                        int position = lytAct2Binding.recyclerView.getChildAdapterPosition(centerView);
                        if (position != RecyclerView.NO_POSITION && selectedIndex != position) {
                            selectedIndex = position;
                            ageSelectorAdapter.setSelectedIndex(position);
                        }
                    }
                }
            }
        });

        // Show image based on saved category
        SharedPreferences sharedPreferences1 = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String name1 = sharedPreferences1.getString("category", "");

        if ("btnOldBody".equals(name1)) {
            lytAct2Binding.imgOld.setImageResource(R.drawable.img_x_image_74);
        } else {
            lytAct2Binding.imgOld.setImageResource(R.drawable.img_x_image_87);
        }

        // Confirm button navigation logic
        lytAct2Binding.btnConfirm.setOnClickListener(v -> {
            SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
            String name = sharedPreferences.getString("category", "");

            Intent intent;
            switch (name) {
                case "btnFullBodyScan":
                case "btnOldBody":
                case "btnBodyFilter":
                    intent = new Intent(SelectAgeActivity.this, SkinTonePickerActivity.class);
                    break;
                case "btnBodyPartName":
                    intent = new Intent(SelectAgeActivity.this, BodyExplorerActivity.class);
                    break;
                case "btnHumanSpecies":
                    intent = new Intent(SelectAgeActivity.this, SpeciesInfoActivity.class);
                    break;
                default:
                    return; // Unknown category, do nothing
            }
            startActivity(intent);
        });
    }

    @Override
    public void onBackPressed() {
        handleBackNavigation();
    }
}
