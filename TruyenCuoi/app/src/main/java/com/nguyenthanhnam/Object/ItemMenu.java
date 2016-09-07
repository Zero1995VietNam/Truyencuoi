package com.nguyenthanhnam.Object;

/**
 * Created by namnguyenthanhnam on 8/5/2016.
 */
public class ItemMenu {
    private int image;
    private String description;

    public ItemMenu(int image, String description) {
        this.image = image;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }
}
