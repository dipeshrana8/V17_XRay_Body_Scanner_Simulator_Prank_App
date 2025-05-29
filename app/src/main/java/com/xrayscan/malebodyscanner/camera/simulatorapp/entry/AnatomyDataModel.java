package com.xrayscan.malebodyscanner.camera.simulatorapp.entry;

public class AnatomyDataModel {
    private final String string;
    private final int imageresid;
    private final String description;

    public AnatomyDataModel(int imageResId, String title, String description) {
        this.string = title;
        this.imageresid = imageResId;
        this.description = description;
    }

    public String getString() {
        return string;
    }

    public int getImageResId() {
        return imageresid;
    }

    public String getDescription() {
        return description;
    }
}
