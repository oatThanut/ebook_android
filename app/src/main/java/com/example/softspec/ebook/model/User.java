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
    private ArrayList<Book> ownBooks;

    public User(String name, int fund) {
        this.name = name;
        this.fund = fund;
        this.ownBooks = new ArrayList<>();
    }

    protected User(Parcel in) {
        ownBooks = new ArrayList<>();
        name = in.readString();
        fund = in.readInt();
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
}
