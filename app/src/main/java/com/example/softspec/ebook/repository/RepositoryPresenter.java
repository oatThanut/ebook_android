package com.example.softspec.ebook.repository;

public class RepositoryPresenter {
    public RepositoryView view;

    public RepositoryPresenter(RepositoryView view) {
        this.view = view;
    }

    public void start() {
        view.setUpListView();
    }


}
