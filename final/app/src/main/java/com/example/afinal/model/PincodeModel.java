package com.example.afinal.model;

public class PincodeModel {

    String id,pincode,locality;

    public PincodeModel(String id, String pincode, String locality) {
        this.id = id;
        this.pincode = pincode;
        this.locality = locality;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }
}
