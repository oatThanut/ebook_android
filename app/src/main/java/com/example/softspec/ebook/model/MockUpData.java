package com.example.softspec.ebook.model;

import java.util.ArrayList;

/**
 * Created by oatThanut on 4/20/2017 AD.
 */

public class MockUpData {
    private ArrayList<Book> list;
    private MockUpData instance;

    public MockUpData() {
        if (instance == null) {
            instance = new MockUpData();
        }
        list = new ArrayList<Book>();
        loadBook();
    }

    private void loadBook() {
        list.add( new Book(
                24.95,
                "https://imagery.pragprog.com/products/471/lhelph_largebeta.jpg",
                471,
                "Functional Web Development with Elixir, OTP, and Phoenix"
        ));

        list.add( new Book(
                24.95,
                "https://imagery.pragprog.com/products/504/jwdsal_largebeta.jpg",
                504,
                "A Common-Sense Guide to Data Structures and Algorithms"
        ));

        list.add( new Book(
                24.95,
                "https://imagery.pragprog.com/products/508/dcbang2_largebeta.jpg",
                508,
                "Rails, Angular, Postgres, and Bootstrap, Second Edition"
        ));

        list.add( new Book(
                19.0,
                "https://imagery.pragprog.com/products/444/rspec3_largebeta.jpg",
                444,
                "Effective Testing with RSpec 3"
        ));

        list.add( new Book(
                26.95,
                "https://imagery.pragprog.com/products/486/mkdsa_largebeta.jpg",
                486,
                "Design It!"
        ));
    }
}
