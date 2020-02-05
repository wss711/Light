package com.gr.light.advanceview.listview;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-03
 **/
public class Country {
    private String name;
    private int imgId;

    public Country(String name, int imgId) {
        this.name = name;
        this.imgId = imgId;
    }

    public String getName() {
        return name;
    }

    public int getImgId() {
        return imgId;
    }
}
