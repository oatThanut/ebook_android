package com.example.softspec.ebook.model;

import java.util.ArrayList;

/**
 * Created by oatThanut on 4/20/2017 AD.
 *  This class use to manage book loader strategy.
 */

public class BookRepositoryManager {
    private ArrayList<Book> bookList;
    private static BookRepositoryManager instance;
    private Strategy plan;

    private BookRepositoryManager(Strategy str) {
        bookList = new ArrayList<Book>();
        setStrategy(str);
    }

    public static BookRepositoryManager getInstance() {
        if (instance == null) {
//             instance = new BookRepositoryManager(MockUpData.getInstance());
            // Uncomment below for retrieve data from JSON
            instance = new BookRepositoryManager(BookLoader.getInstance());
        }
        return instance;
    }

    public void setStrategy(Strategy str) {
        this.plan = str;
    }

    public void loadBook() {
        plan.execute();
    }

    public Strategy getPlan() {
        return this.plan;
    }
}
