package com.xrayscan.malebodyscanner.camera.simulatorapp.featureui;

import static android.view.View.GONE;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.xrayscan.malebodyscanner.camera.simulatorapp.R;
import com.xrayscan.malebodyscanner.camera.simulatorapp.databinding.LytAct15Binding;
import com.xrayscan.malebodyscanner.camera.simulatorapp.databinding.LytAct16Binding;
import com.xrayscan.malebodyscanner.camera.simulatorapp.entry.LocaleDataModel;

import java.util.ArrayList;
import java.util.List;

public class SelectCountryActivity extends MainBaseActivity {
    private final List<LocaleDataModel> localeDataModels = new ArrayList<>();
    private LytAct16Binding lytAct16Binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        topBarTitleText = "Select Your Country";
        super.onCreate(savedInstanceState);


        lytAct16Binding = LytAct16Binding.inflate(getLayoutInflater());
        setContentView(lytAct16Binding.getRoot());
        lytAct16Binding.toolbarLayout.headerTitle.setText("Select Your Country");
        lytAct16Binding.toolbarLayout.btnBack.setOnClickListener(v -> onBackPressed());
        isSettingsEnabled = true;

        lytAct16Binding.toolbarLayout.btnBack.setVisibility(GONE);
        setupLanguageList();
        CountryAdapter countryAdapter = new CountryAdapter(localeDataModels);


        lytAct16Binding.languageRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        lytAct16Binding.languageRecyclerView.setAdapter(countryAdapter);


        lytAct16Binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SelectCountryActivity.this, BodyDetailsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setupLanguageList() {
        localeDataModels.add(new LocaleDataModel("India", R.drawable.img_x_image_93, true));
        localeDataModels.add(new LocaleDataModel("UK", R.drawable.img_x_image_108, false));
        localeDataModels.add(new LocaleDataModel("Canada ", R.drawable.img_x_image_10, false));
        localeDataModels.add(new LocaleDataModel("USA", R.drawable.img_x_image_109, false));
        localeDataModels.add(new LocaleDataModel("Brazil", R.drawable.img_x_image_9, false));
        localeDataModels.add(new LocaleDataModel("Bangladesh", R.drawable.img_x_image_2, false));
        localeDataModels.add(new LocaleDataModel("Australia", R.drawable.img_x_image_1, false));
        localeDataModels.add(new LocaleDataModel("Russia", R.drawable.img_x_image_102, false));


    }

    @Override
    public void onBackPressed() {
        handleBackNavigation();
    }

    public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

        private final List<LocaleDataModel> localeDataModels1;
        private int selectedPosition = 0;

        public CountryAdapter(List<LocaleDataModel> languageList) {
            this.localeDataModels1 = languageList;
            if (!languageList.isEmpty()) languageList.get(0).setSelected(true);
        }

        @NonNull
        @Override
        public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            LytAct15Binding binding = LytAct15Binding.inflate(inflater, parent, false);
            return new CountryViewHolder(binding);
        }

        @Override
        public void onBindViewHolder(@NonNull CountryViewHolder countryViewHolder, int position) {
            LocaleDataModel localeDataModel = localeDataModels1.get(position);
            countryViewHolder.lytAct15Binding.languageName.setText(localeDataModel.getLanguageName());
            countryViewHolder.lytAct15Binding.languageFlag.setImageResource(localeDataModel.getFlagResId());
            countryViewHolder.lytAct15Binding.imgSelect.setVisibility(GONE);
            if (localeDataModel.isSelected()) {
                countryViewHolder.lytAct15Binding.getRoot().setBackgroundResource(R.drawable.img_x_image_4);
                countryViewHolder.lytAct15Binding.imgSelect.setImageResource(R.drawable.img_x_image_20);


            } else {
                countryViewHolder.lytAct15Binding.getRoot().setBackgroundResource(R.drawable.img_x_image_5);
                countryViewHolder.lytAct15Binding.imgSelect.setImageResource(R.drawable.img_x_image_21);


            }


            countryViewHolder.lytAct15Binding.getRoot().setOnClickListener(v -> {
                if (selectedPosition != position) {
                    localeDataModels1.get(selectedPosition).setSelected(false);
                    localeDataModel.setSelected(true);
                    notifyItemChanged(selectedPosition);
                    notifyItemChanged(position);
                    selectedPosition = position;
                }
            });
        }


        @Override
        public int getItemCount() {
            return localeDataModels1.size();
        }

        class CountryViewHolder extends RecyclerView.ViewHolder {
            LytAct15Binding lytAct15Binding;

            CountryViewHolder(LytAct15Binding binding) {
                super(binding.getRoot());
                this.lytAct15Binding = binding;
            }
        }
    }
}