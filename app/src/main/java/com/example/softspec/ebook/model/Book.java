package com.example.softspec.ebook.model;


import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by oatThanut on 4/20/2017 AD.
 *  This is the model of Book
 */

public class Book implements Parcelable {
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

    protected Book(Parcel in) {
        name = in.readString();
        price = in.readDouble();
        id = in.readInt();
        img_url = in.readString();
        year = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeDouble(price);
        dest.writeInt(id);
        dest.writeString(img_url);
        dest.writeString(year);
    }
}
