package com.example.demo.mapper;

import com.example.demo.model.Book;
import com.example.demo.model.dto.BookDto;

import java.util.List;

public interface BookMapper {
    Book bookDtoToBook(BookDto bookDto);

    BookDto bookToBookDto(Book book);

    List<BookDto> BookListToBookDtoList(List<Book> books);
}
