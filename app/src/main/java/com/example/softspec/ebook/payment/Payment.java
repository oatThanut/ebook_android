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
    private TextView textViewName;
    private TextView textViewPrice;
    private TextView textViewUser;
    private TextView textViewFund;
    private ListView listView;
    private ArrayAdapter<Book> bookAdapter;
    private Button buttonPurchase;
    private Button buttonAddFund;
    private EditText fund;
    private Book book;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        user = getIntent().getParcelableExtra("user");
//        book = getIntent().getParcelableExtra("book");
        initial();
    }

    @Override
    public void initial() {
        textViewName = (TextView) findViewById(R.id.textViewName);
        textViewPrice = (TextView) findViewById(R.id.textViewPrice);
        textViewUser = (TextView) findViewById(R.id.textViewUser);
        textViewFund = (TextView) findViewById(R.id.textViewFund);
        listView = (ListView) findViewById(R.id.userBooks);
        buttonPurchase = (Button) findViewById(R.id.buy);
        buttonAddFund = (Button) findViewById(R.id.addFund);
        fund = (EditText) findViewById(R.id.fund);

        textViewName.setText(book.getName());
        textViewPrice.setText("" + book.getPrice());
        textViewUser.setText(user.getName());
        textViewFund.setText("" + user.getFund());
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
//        buttonAddFund.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                    if (!fund.getText().toString().equals("")) {
//                        user.setFund(user.getFund() + Double.parseDouble(fund.getText().toString()));
//                    }
//            }
//        });
//        updateOwnBook();
    }

    public void updateOwnBook() {
            bookAdapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1, user.getOwnBooks());
            listView.setAdapter(bookAdapter);
    }

}
