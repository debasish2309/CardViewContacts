package com.example.devde.cardviewdemo;

public class contact {

    private  int image_id;
    private String name,email,phone;

    public contact(int image_id, String name, String email, String phone) {
        this.image_id = image_id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
  }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
