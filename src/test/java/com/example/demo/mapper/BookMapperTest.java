package com.example.demo.mapper;

import com.example.demo.model.Book;
import com.example.demo.model.dto.BookDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookMapperTest {
    @Autowired
    private BookMapper bookMapper;

    @Test
    public void mapToBookTest() {
        //given
        BookDto bookDto = new BookDto(1L, "test author", "test title","test genre");
        //when
        Book book = bookMapper.bookDtoToBook(bookDto);
        //then
        assertEquals(bookDto.getId(), book.getId());
        assertEquals(bookDto.getAuthor(), book.getAuthor());
        assertEquals(bookDto.getTitle(), book.getTitle());
        assertEquals(bookDto.getGenre(), book.getGenre());
    }

    @Test
    public void mapToBookDtoTest() {
        //given
        Book book = new Book(1L, "test author", "test title","test genre");
        //when
        BookDto bookDto = bookMapper.bookToBookDto(book);
        //then
        assertEquals(book.getId(), bookDto.getId());
        assertEquals(book.getAuthor(), bookDto.getAuthor());
        assertEquals(book.getTitle(), bookDto.getTitle());
        assertEquals(book.getGenre(), bookDto.getGenre());
    }

    @Test
    public void mapToBookDtoListTest() {
        //given
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(2L, "test author", "test title", "test genre"));
        //when
        List<BookDto> bookDtoList = bookMapper.BookListToBookDtoList(bookList);
        //then
        assertEquals(bookList.get(0).getId(), bookDtoList.get(0).getId());
        assertEquals(bookList.get(0).getAuthor(), bookDtoList.get(0).getAuthor());
        assertEquals(bookList.get(0).getTitle(), bookDtoList.get(0).getTitle());
        assertEquals(bookList.get(0).getGenre(), bookDtoList.get(0).getGenre());
        assertEquals(bookList.size(), bookDtoList.size());
    }
}
