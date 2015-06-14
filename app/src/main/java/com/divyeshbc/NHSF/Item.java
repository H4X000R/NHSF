package com.divyeshbc.NHSF;

/**
 * Created by DivyeshBC on 14/06/15.
 */
public class Item {

    public String title;
    public String subtitle;

    Item(String title, String subtitle) {
        this.title = title;
        this.subtitle = subtitle;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }
}

