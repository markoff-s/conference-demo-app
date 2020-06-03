package com.pluralsight.conferencedemo.models;

import lombok.Data;

@Data
public class Book {
    private String title;
    private String isbn;

    public Book(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }
}
