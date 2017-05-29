package com.example.softspec.ebook.cart;

import com.example.softspec.ebook.model.User;

public class CartPresenter {
    private CartView view;
    private User user;

    public CartPresenter(CartView view, User user) {
        this.view = view;
        this.user = user;
    }

    public void start() {
        view.initial();
    }

    public void checkOut() {
        user.checkOut();
        view.updateList();
    }
}
