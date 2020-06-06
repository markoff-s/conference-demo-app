package com.pluralsight.conferencedemo.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.pluralsight.conferencedemo.models.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class BookQueryResolver implements GraphQLQueryResolver {

    public Book getBook(String isbn) {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("First book", "1"));
        books.add(new Book("Second book", "2"));
        books.add(new Book("Third book", "3"));

        return books
                .stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
    }
}
