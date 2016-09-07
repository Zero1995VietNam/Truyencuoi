package com.nguyenthanhnam.Object;

import java.io.Serializable;

/**
 * Created by Nam on 6/25/2016.
 */
public class ItemStory implements Serializable {

   private int id;
    private String nameStory;
    private String type;
    private String country;
    private String content;
    private int like;

    public ItemStory(int id,String nameStory, String type, String country, String content, int like) {
        this.id=id;
        this.nameStory = nameStory;
        this.type = type;
        this.country = country;
        this.content = content;
        this.like = like;
    }

    public String getNameStory() {
        return nameStory;
    }

    public String getType() {
        return type;
    }

    public String getCountry() {
        return country;
    }

    public String getContent() {
        return content;
    }

    public int getLike() {
        return like;
    }

    public int getId() {
        return id;
    }

}
