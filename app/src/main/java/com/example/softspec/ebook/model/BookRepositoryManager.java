package com.example.softspec.ebook.model;

import android.support.v7.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by oatThanut on 4/20/2017 AD.
 *  This class use to manage book loader strategy.
 */

public class BookRepositoryManager {
    private ArrayList<Book> searchBookList;
    private static BookRepositoryManager instance;
    private Strategy plan;

    private BookRepositoryManager(Strategy str) {
        searchBookList = new ArrayList<>();
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
        searchBookList = plan.cloneList();
    }

    public Strategy getPlan() {
        return this.plan;
    }

    public ArrayList<Book> searchByYear(SearchView text) {
        searchBookList.clear();
        for (Book b : plan.getList()) {
            if (b.getYear().contains(text.getQuery().toString())) {
                searchBookList.add(b);
            }
        }
        return searchBookList;
    }

    public ArrayList<Book> searchByName(SearchView text) {
        searchBookList.clear();
        for (Book b : plan.getList()) {
            if (b.getName().toLowerCase().contains(text.getQuery().toString().toLowerCase())) {
                searchBookList.add(b);
            }
        }
        return searchBookList;
    }

    public ArrayList<Book> sortName() {
        Collections.sort(searchBookList, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
            }
        });
        return searchBookList;
    }
}
