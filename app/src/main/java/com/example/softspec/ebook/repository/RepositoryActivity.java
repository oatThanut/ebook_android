package com.example.softspec.ebook.repository;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.softspec.ebook.R;
import com.example.softspec.ebook.model.Book;
import com.example.softspec.ebook.model.JsonData;
import com.example.softspec.ebook.model.MockUpData;

import java.util.ArrayList;

public class RepositoryActivity extends AppCompatActivity implements RepositoryView{

    private ArrayList<Book> list;
    private ArrayAdapter<Book> bookAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        setUpListView();
        list = new ArrayList<>();
        runTask();
        ListView listView = (ListView) findViewById(R.id.listView);
        bookAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, list);
        listView.setAdapter(bookAdapter);
    }

    private void runTask() {
        new JsonData(){

            @Override
            protected void onPostExecute(ArrayList<Book> results) {
                list.clear();
                list.addAll(results);
            }

        }.execute();
    }


    public void setUpListView () {
//        MockUpData m = MockUpData.getInstance();

    }
}
