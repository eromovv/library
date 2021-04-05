package com.library.service;

import com.library.dto.BookDto;
import com.library.model.Book;
import com.library.repository.BookRepository;
import com.library.utils.BookMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookDto saveBook(BookDto bookDto) {
        Book savedBook = bookRepository.save(BookMapper.mapToBookEntity(bookDto));
        return BookMapper.mapToBookDto(savedBook);
    }

    @Override
    public BookDto editBook(Integer id, BookDto bookDto) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        Book book = bookOptional.get();
        book.setTitle(bookDto.getTitle());
        book.setPublishing(bookDto.getPublishing());
        book.setYear(bookDto.getYear());
        return BookMapper.mapToBookDto(bookRepository.save(book));
    }

    @Override
    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }

    @Override
    public BookDto findById(Integer id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            return BookMapper.mapToBookDto(book.get());
        } else {
            return new BookDto();
        }
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll().stream()
                .map(BookMapper::mapToBookDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDto> findByTitle(String title) {
        return bookRepository.findByTitle(title).stream()
                .map(BookMapper::mapToBookDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDto> findByYear(Integer year) {
        return bookRepository.findByYear(year).stream()
                .map(BookMapper::mapToBookDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDto> findByPublishing(String publishing) {
        return bookRepository.findByPublishing(publishing).stream()
                .map(BookMapper::mapToBookDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDto> findByAuthorName(String name) {
       return bookRepository.findByAuthors_Name(name).stream()
                .map(BookMapper::mapToBookDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDto> findByAuthorSurname(String name) {
        return bookRepository.findByAuthors_Surname(name).stream()
                .map(BookMapper::mapToBookDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDto> findByAuthorBirthday(Date birthday) {
        return bookRepository.findByAuthors_Birthday(birthday).stream()
                .map(BookMapper::mapToBookDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDto> findByAuthorGender(String gender) {
        return bookRepository.findByAuthors_Gender(gender).stream()
                .map(BookMapper::mapToBookDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDto> findByAll
            (String title, Integer year, String publishing, String name, String surname, String gender) {
        return bookRepository.findByTitleOrYearOrPublishingOrAuthors_NameOrAuthors_SurnameOrAuthors_Gender
                (title,year,publishing,name,surname, gender).stream()
                .map(BookMapper::mapToBookDto)
                .collect(Collectors.toList());
    }
}
