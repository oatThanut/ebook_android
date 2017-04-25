package com.example.softspec.ebook.model;


/**
 * Created by oatThanut on 4/20/2017 AD.
 *  This is the model of Book
 */

public class Book {
    private String name;
    private double prize;
    private int id;
    private String img_url;

    public Book(double prize, String url, int id, String title) {
        this.name = title;
        this.prize = prize;
        this.id = id;
        this.img_url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrize() {
        return prize;
    }

    public void setPrize(double prize) {
        this.prize = prize;
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

    public String toString() {
        return name;
    }
}
