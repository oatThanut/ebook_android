package com.example.softspec.ebook.model;


/**
 * Created by oatThanut on 4/20/2017 AD.
 */

public class Book {
    private String name;
    private double price;
    private int id;
    private String img_url;

    public Book(double price, String url, int id, String title) {
        name = title;
        this.price = price;
        this.id = id;
        this.img_url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
}
