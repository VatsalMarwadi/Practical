package com.example.afinal.model;

public class OrderModel {

    public String pid;
    public String uid;
    public String pname;
    public String pic1;
    public int qty;
    public int amount;
    public int tot_amount;
    public int c_discount;
    public String date;
    public String time;
    public int status;
    public String c_o;
    public String c_code;
    public String address;
    public String id;

    public OrderModel() {
    }

    public OrderModel(String pid, String uid, String pname, String pic1, int qty, int amount, int tot_amount, int c_discount, String date, String time, int status, String c_o, String c_code, String address, String id) {
        this.pid = pid;
        this.uid = uid;
        this.pname = pname;
        this.pic1 = pic1;
        this.qty = qty;
        this.amount = amount;
        this.tot_amount = tot_amount;
        this.c_discount = c_discount;
        this.date = date;
        this.time = time;
        this.status = status;
        this.c_o = c_o;
        this.c_code = c_code;
        this.address = address;
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPic1() {
        return pic1;
    }

    public void setPic1(String pic1) {
        this.pic1 = pic1;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getTot_amount() {
        return tot_amount;
    }

    public void setTot_amount(int tot_amount) {
        this.tot_amount = tot_amount;
    }

    public int getC_discount() {
        return c_discount;
    }

    public void setC_discount(int c_discount) {
        this.c_discount = c_discount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getC_o() {
        return c_o;
    }

    public void setC_o(String c_o) {
        this.c_o = c_o;
    }

    public String getC_code() {
        return c_code;
    }

    public void setC_code(String c_code) {
        this.c_code = c_code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
