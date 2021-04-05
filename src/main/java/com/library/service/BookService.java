package com.library.service;

import com.library.dto.BookDto;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface BookService {

    BookDto saveBook(BookDto bookDto);

    BookDto editBook(Integer id, BookDto bookDto);

    void deleteBook(Integer id);

    BookDto findById(Integer id);

    List<BookDto> findAll();

    List<BookDto> findByTitle(String title);

    List<BookDto> findByYear(Integer year);

    List<BookDto> findByPublishing(String publishing);

    List<BookDto> findByAuthorName(String name);

    List<BookDto> findByAuthorSurname(String name);

    List<BookDto> findByAuthorBirthday(Date birthday);

    List<BookDto> findByAuthorGender(String gender);

    List<BookDto> findByAll(String title, Integer year, String publishing, String name, String surname, String gender);

}
