package com.example.softspec.ebook.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by oatThanut on 5/19/2017 AD.
 */

public class User implements Parcelable {
    private String name;
    private double fund;
    private ArrayList<Book> cart;
    private ArrayList<Book> ownBooks;

    public User(String name, int fund) {
        this.name = name;
        this.fund = fund;
        cart = new ArrayList<>();
        ownBooks = new ArrayList<>();
    }

    protected User(Parcel in) {
        name = in.readString();
        fund = in.readDouble();
        cart = new ArrayList<>();
        ownBooks = new ArrayList<>();
        in.readList(cart, Book.class.getClassLoader());
        in.readList(ownBooks, Book.class.getClassLoader());
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeDouble(fund);
        dest.writeList(cart);
        dest.writeList(ownBooks);
    }

    public String getName() {
        return name;
    }

    public double getFund() {
        return fund;
    }

    public ArrayList<Book> getOwnBooks() {
        return ownBooks;
    }

    public void setFund(double fund) {
        this.fund = fund;
    }

    public ArrayList<Book> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Book> cart) {
        this.cart = cart;
    }

    public void addToCart(Book book) {
        cart.add(book);
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for(Book book : cart) {
            totalPrice += book.getPrice();
        }
        return totalPrice;
    }

    public boolean checkOut() {
        if( fund < getTotalPrice()) {
            return false;
        }
        fund -= getTotalPrice();
        ownBooks.addAll(cart);
        cart.clear();
        return true;
    }
}
