package org.example.model;

import java.math.BigDecimal;
import java.util.List;

public class QuickViewItem extends Item{

    private String subtitle;
    private String condition;
    private String description;
    private List<String> pictureUrls;
    private List<String> availableSizes;
    private List<String> availableColors;


    public QuickViewItem(String name, BigDecimal price, String subtitle, String condition, String description, List<String> pictureUrls, List<String> availableSizes, List<String> availableColors) {
        super(name, price);
        this.subtitle = subtitle;
        this.condition = condition;
        this.description = description;
        this.pictureUrls = pictureUrls;
        this.availableSizes = availableSizes;
        this.availableColors = availableColors;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getCondition() {
        return condition;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getPictureUrls() {
        return pictureUrls;
    }

    public List<String> getAvailableSizes() {
        return availableSizes;
    }

    public List<String> getAvailableColors() {
        return availableColors;
    }

    public QuickViewItem() {
    }

}
