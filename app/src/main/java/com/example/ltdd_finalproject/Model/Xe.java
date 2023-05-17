package com.example.ltdd_finalproject.Model;

public class Xe {

    private int resourceImg;
    private String name;

    public Xe(int resourceImg, String name) {
        this.resourceImg = resourceImg;
        this.name = name;
    }

    public Xe() {
    }

    public int getResourceImg() {
        return resourceImg;
    }

    public void setResourceImg(int resourceImg) {
        this.resourceImg = resourceImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
