package com.example.softspec.ebook.model;

import java.util.ArrayList;

/**
 * Created by oatThanut on 4/20/2017 AD.
 *  This class is mockup of retrieve data
 */

public class MockUpData implements Strategy {
    private ArrayList<Book> bookList;
    private static MockUpData instance;

    private MockUpData() {
        bookList = new ArrayList<>();
    }

    public static MockUpData getInstance() {
        if (instance == null) {
            instance = new MockUpData();
        }
        return instance;
    }

    @Override
    public void execute() {
        loadBook();
    }

    @Override
    public void loadBook() {
        bookList.add( new Book(
                24.95,
                "https://imagery.pragprog.com/products/471/lhelph_largebeta.jpg",
                471,
                "Functional Web Development with Elixir, OTP, and Phoenix",
                "1"
        ));

        bookList.add( new Book(
                24.95,
                "https://imagery.pragprog.com/products/504/jwdsal_largebeta.jpg",
                504,
                "A Common-Sense Guide to Data Structures and Algorithms",
                "1"
        ));

        bookList.add( new Book(
                24.95,
                "https://imagery.pragprog.com/products/508/dcbang2_largebeta.jpg",
                508,
                "Rails, Angular, Postgres, and Bootstrap, Second Edition",
                "1"
        ));

        bookList.add( new Book(
                19.0,
                "https://imagery.pragprog.com/products/444/rspec3_largebeta.jpg",
                444,
                "Effective Testing with RSpec 3",
                "1"
        ));

        bookList.add( new Book(
                26.95,
                "https://imagery.pragprog.com/products/486/mkdsa_largebeta.jpg",
                486,
                "Design It!",
                "1"
        ));
    }

    @Override
    public ArrayList<Book> getList() {
        return bookList;
    }

    @Override
    public ArrayList<Book> cloneList() {
        return null;
    }

}
