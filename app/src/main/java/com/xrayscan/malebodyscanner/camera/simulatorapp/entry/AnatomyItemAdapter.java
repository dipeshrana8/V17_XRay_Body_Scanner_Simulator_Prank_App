package com.xrayscan.malebodyscanner.camera.simulatorapp.entry;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xrayscan.malebodyscanner.camera.simulatorapp.R;
import com.xrayscan.malebodyscanner.camera.simulatorapp.databinding.LytAct14Binding;

import java.util.List;

public class AnatomyItemAdapter extends RecyclerView.Adapter<AnatomyItemAdapter.ViewHolder> {

    private final List<AnatomyDataModel> list;
    private int selectedPosition = -1;

    public AnatomyItemAdapter(List<AnatomyDataModel> list) {
        this.list = list;
    }

    public AnatomyDataModel getSelectedItem() {
        return selectedPosition != -1 ? list.get(selectedPosition) : null;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LytAct14Binding binding = LytAct14Binding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AnatomyDataModel model = list.get(position);
        holder.binding.imgIcon.setImageResource(model.getImageResId());
        holder.binding.txtName.setText(model.getString());
        holder.binding.itemContainer.setBackgroundResource(
                selectedPosition == position ? R.drawable.img_x_image_4 : R.drawable.img_x_image_5
        );

        holder.itemView.setOnClickListener(v -> {
            selectedPosition = position;
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        LytAct14Binding binding;

        public ViewHolder(LytAct14Binding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}