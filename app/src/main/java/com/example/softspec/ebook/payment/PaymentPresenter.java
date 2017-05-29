package com.example.softspec.ebook.payment;

import com.example.softspec.ebook.model.Book;
import com.example.softspec.ebook.model.User;

public class PaymentPresenter {
    private PaymentView view;
    private User user;
    private Book book;
    public PaymentPresenter(PaymentView view, User user, Book book) {
        this.view = view;
        this.user = user;
        this.book = book;
    }

    public void start() {
        view.initial();
    }

    public void addToCart() {
        user.addToCart(book);
        view.onBackPressed();
    }

}
