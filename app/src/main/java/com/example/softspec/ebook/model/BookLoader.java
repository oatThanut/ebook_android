package com.example.softspec.ebook.model;

import java.util.ArrayList;

/**
 * Created by oatThanut on 4/20/2017 AD.
 *  This class is used to retrieve list of the book from JSON file
 */

public class BookLoader extends Strategy {
    private static BookLoader instance;

    private BookLoader() {

    }

    public static BookLoader getInstance() {
        if (instance == null) {
            instance = new BookLoader();
        }
        return instance;
    }

    @Override
    public void execute() {
        loadBook();
    }

    @Override
    protected void loadBook(){
        // TODO: retrieve data from https://theory.cpe.ku.ac.th/~jittat/courses/sw-spec/ebooks/books.json
    }

    @Override
    public ArrayList<Book> getList() {
        return null;
    }
}
