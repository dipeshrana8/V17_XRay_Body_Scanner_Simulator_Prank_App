package com.xrayscan.malebodyscanner.camera.simulatorapp.entry;

public class LocaleDataModel {
    private final String languageName;
    private final int flagResId;
    private boolean isSelected;

    public LocaleDataModel(String languageName, int flagResId, boolean isSelected) {
        this.languageName = languageName;
        this.flagResId = flagResId;
        this.isSelected = isSelected;
    }

    public String getLanguageName() {
        return languageName;
    }

    public int getFlagResId() {
        return flagResId;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}

