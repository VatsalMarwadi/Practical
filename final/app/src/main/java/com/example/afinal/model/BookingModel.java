package com.example.afinal.model;

public class BookingModel {

    public String uid;
    public String store_id;
    public String time;
    public String date;
    public String guest;
    public int status;
    public String id;

    public BookingModel(String uid, String store_id, String time, String date, String guest, int status, String id) {
        this.uid = uid;
        this.store_id = store_id;
        this.time = time;
        this.date = date;
        this.guest = guest;
        this.status = status;
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getStore_id() {
        return store_id;
    }

    public void setStore_id(String store_id) {
        this.store_id = store_id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGuest() {
        return guest;
    }

    public void setGuest(String guest) {
        this.guest = guest;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}