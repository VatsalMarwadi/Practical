package com.example.afinal.model;

public class CoupenModel {

    String id,c_name,c_pic,c_code;
    Boolean status;

    public CoupenModel(String id, String c_name, String c_pic, String c_code, Boolean status) {
        this.id = id;
        this.c_name = c_name;
        this.c_pic = c_pic;
        this.c_code = c_code;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_pic() {
        return c_pic;
    }

    public void setC_pic(String c_pic) {
        this.c_pic = c_pic;
    }

    public String getC_code() {
        return c_code;
    }

    public void setC_code(String c_code) {
        this.c_code = c_code;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
