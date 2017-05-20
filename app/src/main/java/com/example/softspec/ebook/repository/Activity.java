package com.example.softspec.ebook.repository;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.support.v7.widget.SearchView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.softspec.ebook.R;
import com.example.softspec.ebook.model.Book;
import com.example.softspec.ebook.model.BookRepositoryManager;
import com.example.softspec.ebook.model.User;
import com.example.softspec.ebook.payment.Payment;

import java.util.ArrayList;

import java.util.Observable;
import java.util.Observer;


public class Activity extends AppCompatActivity implements View, Observer {

    private ArrayAdapter<Book> bookAdapter;
    private BookRepositoryManager loader;
    private ListView listView;
    private SearchView text;
    private boolean isSearchByName;
    private Button searchByYearButton;
    private Button searchByNameButton;
    private LinearLayout searchB;
    private Boolean isSearchAppear;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        user = new User("Oat", 100);

        searchB = (LinearLayout)findViewById(R.id.search_container);
        searchB.setVisibility(LinearLayout.GONE);
        isSearchAppear = false;

        isSearchByName = true;
        text = (SearchView) findViewById(R.id.search);
        text.setMaxWidth(Integer.MAX_VALUE);
        searchByYearButton = (Button) findViewById(R.id.year);
        searchByNameButton = (Button) findViewById(R.id.name);
        searchByNameButton.setEnabled(false);
        text.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (isSearchByName) {
                    updateListView(loader.searchByName(text));
                } else {
                    updateListView(loader.searchByYear(text));
                }

                return false;
            }
        });
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
                if(this.isSearchAppear) {
                    searchB.setVisibility(LinearLayout.GONE);
                    this.isSearchAppear = false;
                } else {
                    this.searchB.setVisibility(LinearLayout.VISIBLE);
                    this.isSearchAppear = true;
                }
                return true;

            case R.id.action_sort:
                //TODO: call sort function here
                updateListView(loader.sortName());
                return true;

            case R.id.personal_menu:
                //TODO: call personal menu here

                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    public void setUpListView() {
        loader = BookRepositoryManager.getInstance();
        loader.loadBook();
        listView = (ListView) findViewById(R.id.listView);
        bookAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, loader.getPlan().getList());
        listView.setAdapter(bookAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, android.view.View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), Payment.class);
                intent.putExtra("user", user);
//                Book b = (Book) listView.getItemAtPosition(position);
//                intent.putExtra("book", b);
                startActivity(intent);
            }
        });
    }

    @Override
    public void update(Observable o, Object arg) {

    }


    public void updateListView(ArrayList<Book> books) {
        bookAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, books);
        listView.setAdapter(bookAdapter);
    }

    public void ChooseYear(android.view.View view) {
        searchByYearButton.setEnabled(false);
        searchByNameButton.setEnabled(true);
        isSearchByName = false;
    }

    public void ChooseName(android.view.View view) {
        searchByYearButton.setEnabled(true);
        searchByNameButton.setEnabled(false);
        isSearchByName = true;
    }


}
