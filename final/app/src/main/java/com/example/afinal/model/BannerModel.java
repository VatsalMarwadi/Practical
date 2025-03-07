package com.example.afinal.model;

public class BannerModel {

        String id,banner_name,banner_pic;
        Boolean status;

    public BannerModel(String id, String banner_name, String banner_pic, Boolean status) {
        this.id = id;
        this.banner_name = banner_name;
        this.banner_pic = banner_pic;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBanner_name() {
        return banner_name;
    }

    public void setBanner_name(String banner_name) {
        this.banner_name = banner_name;
    }

    public String getBanner_pic() {
        return banner_pic;
    }

    public void setBanner_pic(String banner_pic) {
        this.banner_pic = banner_pic;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
