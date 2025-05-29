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

public class BodyDetailsActivity extends MainBaseActivity {
    private final List<LocaleDataModel> localeDataModels = new ArrayList<>();
    private LytAct16Binding lytAct16Binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        topBarTitleText = "Select Body Information";
        super.onCreate(savedInstanceState);


        lytAct16Binding = LytAct16Binding.inflate(getLayoutInflater());
        setContentView(lytAct16Binding.getRoot());
        lytAct16Binding.toolbarLayout.headerTitle.setText("Select Body Information");
        lytAct16Binding.toolbarLayout.btnBack.setOnClickListener(v -> onBackPressed());
        isSettingsEnabled = true;
        lytAct16Binding.toolbarLayout.btnBack.setVisibility(GONE);

        setupBodyList();
        BodyDetailsAdapter bodyDetailsAdapter = new BodyDetailsAdapter(localeDataModels);


        lytAct16Binding.languageRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        lytAct16Binding.languageRecyclerView.setAdapter(bodyDetailsAdapter);


        lytAct16Binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(BodyDetailsActivity.this, SelectBodyPartActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setupBodyList() {
        localeDataModels.add(new LocaleDataModel("Brain", R.drawable.img_x_image_38, true));
        localeDataModels.add(new LocaleDataModel("Lungs", R.drawable.img_x_image_64, false));
        localeDataModels.add(new LocaleDataModel("Stomach ", R.drawable.img_x_image_82, false));
        localeDataModels.add(new LocaleDataModel("Heart", R.drawable.img_x_image_56, false));
        localeDataModels.add(new LocaleDataModel("Endocrine", R.drawable.img_x_image_44, false));
        localeDataModels.add(new LocaleDataModel("Large intestine", R.drawable.img_x_image_59, false));


    }

    @Override
    public void onBackPressed() {
        handleBackNavigation();
    }

    public class BodyDetailsAdapter extends RecyclerView.Adapter<BodyDetailsAdapter.LanguageViewHolder> {

        private final List<LocaleDataModel> localeDataModels1;
        private int selectedPosition = 0;

        public BodyDetailsAdapter(List<LocaleDataModel> languageList) {
            this.localeDataModels1 = languageList;
            if (!languageList.isEmpty()) languageList.get(0).setSelected(true);
        }

        @NonNull
        @Override
        public LanguageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            LytAct18Binding binding = LytAct18Binding.inflate(inflater, parent, false);
            return new LanguageViewHolder(binding);
        }

        @Override
        public void onBindViewHolder(@NonNull LanguageViewHolder holder, int position) {
            LocaleDataModel model = localeDataModels1.get(position);
            holder.lytAct18Binding.languageName.setText(model.getLanguageName());
            holder.lytAct18Binding.languageFlag.setImageResource(model.getFlagResId());

            if (model.isSelected()) {
                holder.lytAct18Binding.getRoot().setBackgroundResource(R.drawable.img_x_image_4);
                holder.lytAct18Binding.imgSelect.setImageResource(R.drawable.img_x_image_20);


            } else {
                holder.lytAct18Binding.getRoot().setBackgroundResource(R.drawable.img_x_image_5);
                holder.lytAct18Binding.imgSelect.setImageResource(R.drawable.img_x_image_21);


            }

            holder.lytAct18Binding.getRoot().setOnClickListener(v -> {
                if (selectedPosition != position) {
                    localeDataModels1.get(selectedPosition).setSelected(false);
                    model.setSelected(true);
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

        class LanguageViewHolder extends RecyclerView.ViewHolder {
            LytAct18Binding lytAct18Binding;

            LanguageViewHolder(LytAct18Binding binding) {
                super(binding.getRoot());
                this.lytAct18Binding = binding;
            }
        }
    }
}