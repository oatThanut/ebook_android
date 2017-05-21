package com.example.softspec.ebook.payment;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.softspec.ebook.R;
import com.example.softspec.ebook.model.Book;
import com.example.softspec.ebook.model.BookLoader;
import com.example.softspec.ebook.model.User;

import java.util.List;

public class Payment extends AppCompatActivity implements PaymentView {

    private User user;
    private Book book;
    private TextView textViewName;
    private TextView textViewPrice;
    private Button addToCardButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        user = getIntent().getParcelableExtra("user");
        book = getIntent().getParcelableExtra("book");
        initial();
    }

    @Override
    public void initial() {
        textViewName = (TextView) findViewById(R.id.textViewName);
        textViewPrice = (TextView) findViewById(R.id.textViewPrice);
        addToCardButton = (Button) findViewById(R.id.addToCart);

        textViewName.setText(book.getName());
        textViewPrice.setText("" + book.getPrice());
        addToCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToCart();
            }
        });
    }

    @Override
    public void addToCart() {
        user.addToCart(book);
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        Intent returnedIntent = new Intent();
        returnedIntent.putExtra("user", user);
        setResult(Activity.RESULT_OK, returnedIntent);
        super.onBackPressed();
    }

}
