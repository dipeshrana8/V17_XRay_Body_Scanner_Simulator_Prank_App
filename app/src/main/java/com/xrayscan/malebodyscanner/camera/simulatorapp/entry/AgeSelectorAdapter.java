package com.xrayscan.malebodyscanner.camera.simulatorapp.entry;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xrayscan.malebodyscanner.camera.simulatorapp.R;
import com.xrayscan.malebodyscanner.camera.simulatorapp.databinding.LytAct12Binding;

import java.util.List;

public class AgeSelectorAdapter extends RecyclerView.Adapter<AgeSelectorAdapter.AgeViewHolder> {
    private final List<Integer> integerList;
    private int selectedIndex = 2;

    public AgeSelectorAdapter(List<Integer> ageList) {
        this.integerList = ageList;
    }

    public void setSelectedIndex(int index) {
        selectedIndex = index;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AgeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LytAct12Binding binding = LytAct12Binding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new AgeViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AgeViewHolder holder, int position) {
        int age = integerList.get(position);
        holder.binding.txtAge.setText(String.valueOf(age));

        if (position == selectedIndex) {
            holder.binding.txtAge.setTextColor(Color.WHITE);
            holder.binding.txtAge.setBackgroundResource(R.drawable.img_x_image_7);
            holder.binding.txtAge.setTextSize(24f);
        } else {
            holder.binding.txtAge.setTextColor(Color.GRAY);
            holder.binding.txtAge.setBackgroundResource(R.drawable.img_x_image_8);
            holder.binding.txtAge.setTextSize(18f);
        }
    }

    @Override
    public int getItemCount() {
        return integerList.size();
    }

    public static class AgeViewHolder extends RecyclerView.ViewHolder {
        LytAct12Binding binding;

        public AgeViewHolder(@NonNull LytAct12Binding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}