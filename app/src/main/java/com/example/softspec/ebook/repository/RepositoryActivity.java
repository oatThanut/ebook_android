package com.example.softspec.ebook.repository;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.softspec.ebook.R;
import com.example.softspec.ebook.model.Book;
import com.example.softspec.ebook.model.BookRepositoryManager;

public class RepositoryActivity extends AppCompatActivity implements RepositoryView {

    private ArrayAdapter<Book> bookAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpListView();
    }


    public void setUpListView() {
        BookRepositoryManager loader = BookRepositoryManager.getInstance();
        loader.loadBook();
        ListView listView = (ListView) findViewById(R.id.listView);
        bookAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, loader.getPlan().getList());
        listView.setAdapter(bookAdapter);

    }
}
