package com.example.softspec.ebook.model;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by oatThanut on 4/20/2017 AD.
 *  This class is used to retrieve list of the book from JSON file
 */

public class BookLoader extends Observable implements Strategy {
    private static BookLoader instance;
    private JsonData jsonData;
    private ArrayList<Book> bookArrayList;

    private BookLoader() {
        jsonData = new JsonData();
        bookArrayList = new ArrayList<>();
    }

    public static BookLoader getInstance() {
        if (instance == null) {
            instance = new BookLoader();
        }
        return instance;
    }

    @Override
    public void execute() {
        loadBook();
    }

    @Override
    public void loadBook() {
        jsonData.execute();
    }

    @Override
    public ArrayList<Book> getList() {
        return bookArrayList;
    }


    private class JsonData extends AsyncTask<Void, Void, ArrayList<Book>> {

        private ArrayList<Book> books = new ArrayList<>();

        @Override
        protected ArrayList<Book> doInBackground(Void... params) {
            StringBuilder listJsonStr = loadBookJson();
            if (listJsonStr == null) {
                return null;
            }
            ArrayList<Book> results = new ArrayList<>();
            try {

                JSONArray bookArr = new JSONArray(listJsonStr.toString());

                for (int i = 0; i < bookArr.length(); i++) {
                    JSONObject bookJson = bookArr.getJSONObject(i);
                    Book book = new Book(bookJson.getDouble("price"),
                            bookJson.getString("img_url"),
                            bookJson.getInt("id"),
                            bookJson.getString("title"),
                            bookJson.getString("pub_year"));
                    results.add(book);
                }

            } catch (JSONException e) {
                return null;
            }
            return results;
        }

        private StringBuilder loadBookJson() {

            StringBuilder result = new StringBuilder();
            try {
                URL url = new URL("https://theory.cpe.ku.ac.th/~jittat/courses/sw-spec/ebooks/books.json");
                URLConnection connection = url.openConnection();
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        connection.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    result.append(inputLine);
                }

                return result;
            } catch (IOException e) {
                return null;
            }
        }

        @Override
        protected void onPostExecute(ArrayList<Book> results) {
            bookArrayList.clear();
            for(Book b: results) {
                bookArrayList.add(b);
            }
            setChanged();
            notifyObservers();
        }
    }
}