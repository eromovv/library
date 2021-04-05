package com.library.utils;

import com.library.dto.BookDto;
import com.library.model.Book;
import org.springframework.stereotype.Component;

/**
 *
 */

@Component
public class BookMapper {

    public static BookDto mapToBookDto(Book book){
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setTitle(book.getTitle());
        bookDto.setYear(book.getYear());
        bookDto.setPublishing(book.getPublishing());
        return bookDto;
    }

    public static Book mapToBookEntity(BookDto bookDto){
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setYear(bookDto.getYear());
        book.setPublishing(bookDto.getPublishing());
        return book;
    }
}
