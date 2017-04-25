package com.example.softspec.ebook.model;

import java.util.ArrayList;

/**
 * Created by oatThanut on 4/24/2017 AD.
 */

public interface Strategy {
    public void execute();
    public void loadBook();
    public ArrayList<Book> getList();
}
