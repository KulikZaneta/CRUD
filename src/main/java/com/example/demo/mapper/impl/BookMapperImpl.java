package com.example.demo.mapper.impl;

import com.example.demo.mapper.BookMapper;
import com.example.demo.model.Book;
import com.example.demo.model.dto.BookDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public Book bookDtoToBook(BookDto bookDto) {
        return Book.builder()
                .author(bookDto.getAuthor())
                .genre(bookDto.getGenre())
                .id(bookDto.getId())
                .title(bookDto.getTitle())
                .build();
    }

    @Override
    public BookDto bookToBookDto(Book book) {
        return BookDto.builder()
                .author(book.getAuthor())
                .genre(book.getGenre())
                .id(book.getId())
                .title(book.getTitle())
                .build();
    }

    @Override
    public List<BookDto> BookListToBookDtoList(List<Book> books) {
        return books.stream()
                .map(this::bookToBookDto)
                .collect(Collectors.toList());
    }
}
