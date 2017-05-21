package com.example.softspec.ebook.payment;

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
    private TextView textViewUser;
    private TextView textViewFund;
    private ListView listView;
    private ArrayAdapter<Book> bookAdapter;
    private Button buttonPurchase;
    private Button buttonAddFund;
    private EditText fund;


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
        buttonPurchase = (Button) findViewById(R.id.buy);

        textViewName.setText(book.getName());
        textViewPrice.setText("" + book.getPrice());
//        buttonPurchase.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (user.getFund() > book.getPrice()) {
//                    user.setFund(user.getFund() - book.getPrice());
//                    user.getOwnBooks().add(book);
//                    updateOwnBook();
//                }
//            }
//        });
//
//        updateOwnBook();
    }

    public void updateOwnBook() {
            bookAdapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1, user.getOwnBooks());
            listView.setAdapter(bookAdapter);
    }

}
