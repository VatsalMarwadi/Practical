package com.example.afinal.model;

import java.util.ArrayList;

public class DataOutputModel {

    String message;
    Boolean status;
    public ArrayList<BannerModel> banner;
    public ArrayList<CoupenModel> coupen;
    public ArrayList<CatModel> category;
    public ArrayList<ProModel> product;
    public ArrayList<ToppingModel> topping;
    public ArrayList<PincodeModel> pincode;
    public ArrayList<StoreModel> store;

    public DataOutputModel(String message, Boolean status, ArrayList<BannerModel> banner, ArrayList<CoupenModel> coupen, ArrayList<CatModel> category, ArrayList<ProModel> product, ArrayList<ToppingModel> topping, ArrayList<PincodeModel> pincode, ArrayList<StoreModel> store) {
        this.message = message;
        this.status = status;
        this.banner = banner;
        this.coupen = coupen;
        this.category = category;
        this.product = product;
        this.topping = topping;
        this.pincode = pincode;
        this.store = store;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public ArrayList<BannerModel> getBanner() {
        return banner;
    }

    public void setBanner(ArrayList<BannerModel> banner) {
        this.banner = banner;
    }

    public ArrayList<CoupenModel> getCoupen() {
        return coupen;
    }

    public void setCoupen(ArrayList<CoupenModel> coupen) {
        this.coupen = coupen;
    }

    public ArrayList<CatModel> getCategory() {
        return category;
    }

    public void setCategory(ArrayList<CatModel> category) {
        this.category = category;
    }

    public ArrayList<ProModel> getProduct() {
        return product;
    }

    public void setProduct(ArrayList<ProModel> product) {
        this.product = product;
    }

    public ArrayList<ToppingModel> getTopping() {
        return topping;
    }

    public void setTopping(ArrayList<ToppingModel> topping) {
        this.topping = topping;
    }

    public ArrayList<PincodeModel> getPincode() {
        return pincode;
    }

    public void setPincode(ArrayList<PincodeModel> pincode) {
        this.pincode = pincode;
    }

    public ArrayList<StoreModel> getStore() {
        return store;
    }

    public void setStore(ArrayList<StoreModel> store) {
        this.store = store;
    }
}
