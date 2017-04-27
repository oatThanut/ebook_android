package com.example.softspec.ebook.repository;

import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.softspec.ebook.R;
import com.example.softspec.ebook.model.Book;
import com.example.softspec.ebook.model.BookRepositoryManager;

import java.util.ArrayList;

import java.util.Observable;
import java.util.Observer;


public class Activity extends AppCompatActivity implements View, Observer {

    private ArrayAdapter<Book> bookAdapter;
    private BookRepositoryManager loader;
    private ArrayList<Book> bs;
    private ListView listView;
    private SearchView text;
    private boolean check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bs = new ArrayList<>();
        check = true;
        text = (SearchView) findViewById(R.id.search);
        text.setMaxWidth(Integer.MAX_VALUE);
        text.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (check) {
                    searchByName();
                } else {
                    searchByYear();
                }

                return false;
            }
        });
        setUpListView();
    }


    public void setUpListView() {
        loader = BookRepositoryManager.getInstance();
        loader.loadBook();
        listView = (ListView) findViewById(R.id.listView);
        bookAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, loader.getPlan().getList());
        listView.setAdapter(bookAdapter);

    }

    @Override
    public void update(Observable o, Object arg) {
        setUpListView();
    }

    public void searchByYear() {
        bs.clear();
        for (Book b : loader.getPlan().getList()) {
            if (b.getYear().contains(text.getQuery().toString())) {
                bs.add(b);
            }
        }
        updateListView(bs);
    }

    public void searchByName() {
        bs.clear();
        for (Book b : loader.getPlan().getList()) {
            if (b.getName().contains(text.getQuery().toString())) {
                bs.add(b);
            }
        }
        updateListView(bs);
    }

    public void updateListView(ArrayList<Book> books) {
        bookAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, books);
        listView.setAdapter(bookAdapter);
    }

    public void ChooseYear(android.view.View view) {
        Button button1 = (Button) findViewById(R.id.year);
        Button button2 = (Button) findViewById(R.id.name);
        button1.setEnabled(false);
        button2.setEnabled(true);
        check = false;
    }

    public void ChooseName(android.view.View view) {
        Button button2 = (Button) findViewById(R.id.year);
        Button button1 = (Button) findViewById(R.id.name);
        button1.setEnabled(false);
        button2.setEnabled(true);
        check = true;
    }
}
