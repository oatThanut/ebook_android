package com.example.softspec.ebook.cart;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.softspec.ebook.R;
import com.example.softspec.ebook.model.Book;
import com.example.softspec.ebook.model.User;

import java.util.ArrayList;

/**
 * Created by oatThanut on 5/22/2017 AD.
 */

public class Cart extends AppCompatActivity implements CartView {
    private User user;
    private TextView textViewPrice;
    private ListView listView;
    private Adapter bookAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        user = getIntent().getParcelableExtra("user");
        initial();
    }

    @Override
    public void initial() {
        textViewPrice = (TextView) findViewById(R.id.textViewPrice);
        final Button checkout = (Button) findViewById(R.id.checkOutButton);
        checkout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                checkOut();
                onBackPressed();
            }
        });

        updateList();
    }

    private void updateList() {
        textViewPrice.setText("" + user.getTotalPrice());
        listView = (ListView) findViewById(R.id.cartListView);
        bookAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, (ArrayList<Book>)user.getCart());
        listView.setAdapter((ListAdapter) bookAdapter);
    }


    @Override
    public void checkOut() {
        user.checkOut();
        updateList();

    }

    @Override
    public void onBackPressed() {
        Intent returnedIntent = new Intent();
        returnedIntent.putExtra("user", user);
        setResult(Activity.RESULT_OK, returnedIntent);
        super.onBackPressed();
    }
}
