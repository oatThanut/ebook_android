package com.example.softspec.ebook.repository;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.softspec.ebook.R;
import com.example.softspec.ebook.model.Book;
import com.example.softspec.ebook.model.BookRepositoryManager;

import java.util.Observable;
import java.util.Observer;

public class Activity extends AppCompatActivity implements View, Observer {

    private ArrayAdapter<Book> bookAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        setUpListView();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_action_bar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                //TODO: call hide/show searchView
                return true;

            case R.id.action_sort:
                //TODO: call sort function here
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    public void setUpListView() {
        BookRepositoryManager loader = BookRepositoryManager.getInstance();
        loader.loadBook();
        ListView listView = (ListView) findViewById(R.id.listView);
        bookAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, loader.getPlan().getList());
        listView.setAdapter(bookAdapter);

    }

    @Override
    public void update(Observable o, Object arg) {
        setUpListView();
    }
}
