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

public class JsonData extends AsyncTask<Void, Void, ArrayList<Book>> {

    @Override
    protected ArrayList<Book> doInBackground(Void... params) {
        StringBuilder listJsonStr = loadBookJson();
        if (listJsonStr == null) {
            return null;
        }
        ArrayList<Book> results = new ArrayList<>();
        try {
            JSONObject jsonObj = new JSONObject(listJsonStr.toString());
            JSONArray trendArr = jsonObj.getJSONArray("Book");

            for (int i = 0; i < trendArr.length(); i++) {
                JSONObject bookJson = trendArr.getJSONObject(i);
                Book book = new Book(bookJson.getDouble("price"),
                                     bookJson.getString("url"),
                                     bookJson.getInt("id"),
                                     bookJson.getString("name"));
                results.add(book);
            }
        }catch (JSONException e) {
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
}
