package com.example.afinal.model;

import java.io.Serializable;

public class ProModel implements Serializable {

    String id,product_name,product_pic1,product_pic2,product_desc,product_discount,product_price,product_vegnon,product_ingredient,product_flavour,product_bestseller,product_category,product_sugerfree;

    public ProModel(String id, String product_name, String product_pic1, String product_pic2, String product_desc, String product_discount, String product_price, String product_vegnon, String product_ingredient, String product_flavour, String product_bestseller, String product_category, String product_sugerfree) {
        this.id = id;
        this.product_name = product_name;
        this.product_pic1 = product_pic1;
        this.product_pic2 = product_pic2;
        this.product_desc = product_desc;
        this.product_discount = product_discount;
        this.product_price = product_price;
        this.product_vegnon = product_vegnon;
        this.product_ingredient = product_ingredient;
        this.product_flavour = product_flavour;
        this.product_bestseller = product_bestseller;
        this.product_category = product_category;
        this.product_sugerfree = product_sugerfree;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduct_desc() {
        return product_desc;
    }

    public void setProduct_desc(String product_desc) {
        this.product_desc = product_desc;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_pic1() {
        return product_pic1;
    }

    public void setProduct_pic1(String product_pic1) {
        this.product_pic1 = product_pic1;
    }

    public String getProduct_pic2() {
        return product_pic2;
    }

    public void setProduct_pic2(String product_pic2) {
        this.product_pic2 = product_pic2;
    }

    public String getProduct_discount() {
        return product_discount;
    }

    public void setProduct_discount(String product_discount) {
        this.product_discount = product_discount;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public String getProduct_vegnon() {
        return product_vegnon;
    }

    public void setProduct_vegnon(String product_vegnon) {
        this.product_vegnon = product_vegnon;
    }

    public String getProduct_ingredient() {
        return product_ingredient;
    }

    public void setProduct_ingredient(String product_ingredient) {
        this.product_ingredient = product_ingredient;
    }

    public String getProduct_flavour() {
        return product_flavour;
    }

    public void setProduct_flavour(String product_flavour) {
        this.product_flavour = product_flavour;
    }

    public String getProduct_bestseller() {
        return product_bestseller;
    }

    public void setProduct_bestseller(String product_bestseller) {
        this.product_bestseller = product_bestseller;
    }

    public String getProduct_category() {
        return product_category;
    }

    public void setProduct_category(String product_category) {
        this.product_category = product_category;
    }

    public String getProduct_sugerfree() {
        return product_sugerfree;
    }

    public void setProduct_sugerfree(String product_sugerfree) {
        this.product_sugerfree = product_sugerfree;
    }
}
