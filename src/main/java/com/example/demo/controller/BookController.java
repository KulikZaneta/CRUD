package com.example.demo.controller;

import com.example.demo.mapper.BookMapper;
import com.example.demo.model.Book;
import com.example.demo.model.dto.BookDto;
import com.example.demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BookController {

    private final BookMapper bookMapper;
    private final BookService bookService;

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.findAllBook();
    }

    @GetMapping("/{id}")
    public BookDto bookById(@PathVariable Long id) {
        return bookMapper.bookToBookDto(bookService.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDto addBook(@RequestBody BookDto bookDto) {
        return bookMapper.bookToBookDto(bookService.save(bookMapper.bookDtoToBook(bookDto)));
    }

    @PutMapping
    public BookDto updateBook(@RequestBody BookDto bookDto) {
        return bookMapper.bookToBookDto(bookService.update(bookMapper.bookDtoToBook(bookDto)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
    }
}
