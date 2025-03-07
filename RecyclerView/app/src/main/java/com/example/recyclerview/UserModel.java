package com.example.recyclerview;

public class UserModel {

    String image,name,email;

    public UserModel(String image, String name, String email) {
        this.image = image;
        this.name = name;
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
