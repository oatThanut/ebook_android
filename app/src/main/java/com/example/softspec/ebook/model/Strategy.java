package com.example.softspec.ebook.model;

import java.util.ArrayList;

public interface Strategy {
    public void execute();
    public void loadBook();
    public ArrayList<Book> getList();
    public ArrayList<Book> cloneList();
}
