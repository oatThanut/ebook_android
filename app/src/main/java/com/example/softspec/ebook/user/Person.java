package com.example.softspec.ebook.user;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.softspec.ebook.R;
import com.example.softspec.ebook.model.Book;
import com.example.softspec.ebook.model.User;

import java.util.ArrayList;

/**
 * Created by oatThanut on 5/21/2017 AD.
 */

public class Person extends AppCompatActivity implements PersonView {
    private User user;
    private Button addButton;
    private ListView listView;
    private Adapter bookAdapter;
    private TextView nameTextView;
    private TextView fundTextView;
    private EditText addFundEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);

        user = getIntent().getParcelableExtra("user");

        init();
    }

    private void init() {
        addButton = (Button) findViewById(R.id.addFundButton);
        nameTextView = (TextView) findViewById(R.id.nameTextView);
        fundTextView = (TextView) findViewById(R.id.fundTextView);
        addFundEditText = (EditText) findViewById(R.id.addFundTextEdit);

        nameTextView.setText(user.getName());
        fundTextView.setText("" + user.getFund());

        addButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                addFund();
            }
        });

        addFundEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    addFundEditText.setHint("");
                else
                    addFundEditText.setHint("Enter fund here");
            }
        });

        setUpList();
    }

    private void setUpList() {
        listView = (ListView) findViewById(R.id.ownBookListView);
        bookAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, (ArrayList<Book>)user.getOwnBooks());
        listView.setAdapter((ListAdapter) bookAdapter);
    }

    @Override
    public void addFund() {
        if(Double.parseDouble(String.valueOf(addFundEditText.getText())) >= 0) {
            user.setFund(Double.parseDouble(String.valueOf(addFundEditText.getText())));
        }
        fundTextView.setText("" + user.getFund());
    }
}
