package com.example.appfood;

public class Food {

    public static final int TypeRecent = 1;
    public static final int TypeNearBy = 2;

    private int image;
    private String name;
    private String description;
    private int type;

    public Food(int image, String name, String description, int type) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
