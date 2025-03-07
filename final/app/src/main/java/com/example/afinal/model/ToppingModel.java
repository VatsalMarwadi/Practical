package com.example.afinal.model;

public class ToppingModel {

    String id,toopping_name,toopping_pic,toopping_price;

    public ToppingModel(String id, String toopping_name, String toopping_pic, String toopping_price) {
        this.id = id;
        this.toopping_name = toopping_name;
        this.toopping_pic = toopping_pic;
        this.toopping_price = toopping_price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToopping_name() {
        return toopping_name;
    }

    public void setToopping_name(String toopping_name) {
        this.toopping_name = toopping_name;
    }

    public String getToopping_pic() {
        return toopping_pic;
    }

    public void setToopping_pic(String toopping_pic) {
        this.toopping_pic = toopping_pic;
    }

    public String getToopping_price() {
        return toopping_price;
    }

    public void setToopping_price(String toopping_price) {
        this.toopping_price = toopping_price;
    }
}
