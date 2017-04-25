package com.example.softspec.ebook.model;

import java.util.ArrayList;

/**
 * Created by oatThanut on 4/24/2017 AD.
 */

public abstract class Strategy {
    public void execute(){}
    protected void loadBook(){}
    public ArrayList<Book> getList(){ return new ArrayList<>();}

}
