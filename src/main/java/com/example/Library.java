package com.example;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<String> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(String book) {
        books.add(book);
    }

    public void removeBook(String book) {
        books.remove(book);
    }

    public boolean isBookAvailable(String book) {
        return books.contains(book);
    }

    public List<String> getBooks() {
        return new ArrayList<>(books);
    }
}