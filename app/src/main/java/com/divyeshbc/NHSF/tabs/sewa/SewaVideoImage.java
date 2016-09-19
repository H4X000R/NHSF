package com.divyeshbc.NHSF.tabs.sewa;

/**
 * Created by DivyeshBC on 18/11/15.
 */
public class SewaVideoImage {

    public String title;
    public String subtitle;
    public int iconId;

    public SewaVideoImage(String title, String subtitle, int iconId) {
        this.title = title;
        this.subtitle = subtitle;
        this.iconId = iconId;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public int getIconId() { return iconId; }
}
