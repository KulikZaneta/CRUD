package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.impl.BookServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {
    @InjectMocks
    private BookServiceImpl bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    public void testGetAllBooks() {
        //given
        List<Book> bookList = new ArrayList<>();
        Book book = new Book(1L, "test author", "test title", "test genre");
        bookList.add(book);
        when(bookRepository.findAll()).thenReturn(bookList);
        //when
        List<Book> exam = bookService.findAllBook();
        //then
        assertEquals(1, exam.size());
    }

    @Test
    public void testGetBookById() {
        //given
        Long id = 3L;
        Book book = new Book(3L, "test author", "test title","test genre");
        //when
        when(bookRepository.save(book)).thenReturn(book);
        Book savedBook = bookService.save(book);
        //then
        assertEquals(3L, savedBook.getId());
        assertEquals("test author", savedBook.getAuthor());
        assertEquals("test title", savedBook.getTitle());
        assertEquals("test genre", savedBook.getGenre());
    }

    @Test
    public void testSaveBook() {
        //given
        Long id = 3L;
        Book book = new Book(3L, "test author", "test title","test genre");
        //when
        when(bookRepository.save(book)).thenReturn(book);
        Book savedBook = bookService.save(book);
        //then
        assertEquals(3L, savedBook.getId());
        assertEquals("test author", savedBook.getAuthor());
        assertEquals("test title", savedBook.getTitle());
        assertEquals("test genre", savedBook.getGenre());
    }
}
