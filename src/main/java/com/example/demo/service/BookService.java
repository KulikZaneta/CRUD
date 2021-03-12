package com.example.demo.service;

import com.example.demo.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAllBook();

    Book findById(Long id);

    Book save(Book books);

    Book update(Book book);

    void deleteById(Long id);
}
