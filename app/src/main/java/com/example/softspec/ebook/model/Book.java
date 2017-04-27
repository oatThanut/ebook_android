package com.example.softspec.ebook.model;


/**
 * Created by oatThanut on 4/20/2017 AD.
 *  This is the model of Book
 */

public class Book {
    private String name;
    private double price;
    private int id;
    private String img_url;
    private String year;
    public Book(double price, String url, int id, String title, String year) {
        this.name = title;
        this.price = price;
        this.id = id;
        this.img_url = url;
        this.year = year;
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

    public String getYear() {
        return year;
    }
    public String toString() {
        return String.format("%s\n%.2f\n%s",name, price, year);
    }
}
