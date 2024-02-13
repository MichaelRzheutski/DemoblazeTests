package com.solvd.domain;

public class FooterContent {
    private String title;
    private String text;
    private String address;
    private String phone;
    private String email;
    private String img;

    public FooterContent() {
    }

    public FooterContent(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public FooterContent(String title,
                         String address,
                         String phone,
                         String email) {
        this.title = title;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
