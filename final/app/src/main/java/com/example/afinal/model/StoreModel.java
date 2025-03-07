package com.example.afinal.model;

public class StoreModel {

    String id,store_name,store_pic,store_address,pincode;

    public StoreModel(String id, String store_name, String store_pic, String store_address, String pincode) {
        this.id = id;
        this.store_name = store_name;
        this.store_pic = store_pic;
        this.store_address = store_address;
        this.pincode = pincode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public String getStore_pic() {
        return store_pic;
    }

    public void setStore_pic(String store_pic) {
        this.store_pic = store_pic;
    }

    public String getStore_address() {
        return store_address;
    }

    public void setStore_address(String store_address) {
        this.store_address = store_address;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}
