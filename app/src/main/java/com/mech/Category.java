package com.mech;

/**
 * Created by Agustin on 15/7/2017.
 */

public class Category {

    private String name;
    private String detail;
    private int pictureId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
