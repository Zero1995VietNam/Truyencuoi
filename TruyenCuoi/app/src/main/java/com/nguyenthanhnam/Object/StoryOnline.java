package com.nguyenthanhnam.Object;

/**
 * Created by namnguyenthanhnam on 8/30/2016.
 */
public class StoryOnline {
    private String imageUrl;
    private String nameStory;
    private String link;

    public StoryOnline(String imageUrl, String nameStory, String link) {

        this.imageUrl = imageUrl;
        this.nameStory = nameStory;
        this.link = link;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getNameStory() {
        return nameStory;
    }


    public String getLink() {
        return link;
    }
}
