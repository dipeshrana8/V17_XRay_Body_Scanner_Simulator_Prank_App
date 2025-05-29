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
import com.xrayscan.malebodyscanner.camera.simulatorapp.databinding.LytAct16Binding;
import com.xrayscan.malebodyscanner.camera.simulatorapp.databinding.LytAct18Binding;
import com.xrayscan.malebodyscanner.camera.simulatorapp.entry.LocaleDataModel;

import java.util.ArrayList;
import java.util.List;

public class SelectBodyPartActivity extends MainBaseActivity {
    private final List<LocaleDataModel> localeDataModels = new ArrayList<>();
    private LytAct16Binding lytAct16Binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        topBarTitleText = "Select Body Part";
        super.onCreate(savedInstanceState);


        lytAct16Binding = LytAct16Binding.inflate(getLayoutInflater());
        setContentView(lytAct16Binding.getRoot());

        isSettingsEnabled = true;
        lytAct16Binding.toolbarLayout.headerTitle.setText("Select Body Part");
        lytAct16Binding.toolbarLayout.btnBack.setOnClickListener(v -> onBackPressed());
        setBodypartList();
        BodyDetailsAdapter bodyDetailsAdapter = new BodyDetailsAdapter(localeDataModels);
        lytAct16Binding.toolbarLayout.btnBack.setVisibility(GONE);

        lytAct16Binding.languageRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        lytAct16Binding.languageRecyclerView.setAdapter(bodyDetailsAdapter);


        lytAct16Binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SelectBodyPartActivity.this, BodyScannerActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setBodypartList() {
        localeDataModels.add(new LocaleDataModel("Muscular", R.drawable.img_x_image_66, true));
        localeDataModels.add(new LocaleDataModel("Skeletal", R.drawable.img_x_image_75, false));
        localeDataModels.add(new LocaleDataModel("Vascular", R.drawable.img_x_image_86, false));
        localeDataModels.add(new LocaleDataModel("Respiratory", R.drawable.img_x_image_73, false));
        localeDataModels.add(new LocaleDataModel("Nervous", R.drawable.img_x_image_67, false));
        localeDataModels.add(new LocaleDataModel("Digestive", R.drawable.img_x_image_43, false));


    }

    @Override
    public void onBackPressed() {
        handleBackNavigation();
    }

    public class BodyDetailsAdapter extends RecyclerView.Adapter<BodyDetailsAdapter.BodyDetailsViewHolder> {

        private final List<LocaleDataModel> localeDataModels1;
        private int selectedPosition = 0;

        public BodyDetailsAdapter(List<LocaleDataModel> languageList) {
            this.localeDataModels1 = languageList;
            if (!languageList.isEmpty()) languageList.get(0).setSelected(true);
        }

        @NonNull
        @Override
        public BodyDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            LytAct18Binding binding = LytAct18Binding.inflate(inflater, parent, false);
            return new BodyDetailsViewHolder(binding);
        }

        @Override
        public void onBindViewHolder(@NonNull BodyDetailsViewHolder bodyDetailsViewHolder, int position) {
            LocaleDataModel localeDataModel = localeDataModels1.get(position);
            bodyDetailsViewHolder.lytAct18Binding.languageName.setText(localeDataModel.getLanguageName());
            bodyDetailsViewHolder.lytAct18Binding.languageFlag.setImageResource(localeDataModel.getFlagResId());

            if (localeDataModel.isSelected()) {
                bodyDetailsViewHolder.lytAct18Binding.getRoot().setBackgroundResource(R.drawable.img_x_image_4);
                bodyDetailsViewHolder.lytAct18Binding.imgSelect.setImageResource(R.drawable.img_x_image_20);


            } else {
                bodyDetailsViewHolder.lytAct18Binding.getRoot().setBackgroundResource(R.drawable.img_x_image_5);
                bodyDetailsViewHolder.lytAct18Binding.imgSelect.setImageResource(R.drawable.img_x_image_21);


            }


            bodyDetailsViewHolder.lytAct18Binding.getRoot().setOnClickListener(v -> {
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

        class BodyDetailsViewHolder extends RecyclerView.ViewHolder {
            LytAct18Binding lytAct18Binding;

            BodyDetailsViewHolder(LytAct18Binding binding) {
                super(binding.getRoot());
                this.lytAct18Binding = binding;
            }
        }
    }
}