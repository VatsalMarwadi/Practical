package com.example.practise.utils;

public class CatModel {

    String id,category_name,category_pic;

    public CatModel(String id, String category_name, String category_pic) {
        this.id = id;
        this.category_name = category_name;
        this.category_pic = category_pic;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_pic() {
        return category_pic;
    }

    public void setCategory_pic(String category_pic) {
        this.category_pic = category_pic;
    }
}
