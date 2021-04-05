package com.library.controller;

import com.library.dto.BookDto;
import com.library.service.BookServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/books")
@AllArgsConstructor
public class BookController {

    private BookServiceImpl bookService;

    @PostMapping(value = "/save")
    public ResponseEntity<BookDto> save(@Validated @RequestBody BookDto bookDto) {
        BookDto bookDto1 = bookService.saveBook(bookDto);
        return new ResponseEntity<>(bookDto1, HttpStatus.OK);
    }

    @PutMapping(value = "/edit/{id}")
    public ResponseEntity<BookDto> edit(@Validated @PathVariable("id") Integer id, @RequestBody BookDto bookDto) {
        BookDto bookDto1 = bookService.editBook(id, bookDto);
        return new ResponseEntity<>(bookDto1, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        bookService.deleteBook(id);
    }

    @GetMapping(value = "/find")
    public List<BookDto> find() {
        return bookService.findAll();
    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<BookDto> find(@PathVariable("id") Integer id) {
        BookDto bookDto = bookService.findById(id);
        return new ResponseEntity<>(bookDto, HttpStatus.OK);
    }

    @GetMapping(value = "/find-by-title")
    public List<BookDto> titleSearch(@RequestParam String title) {
        return bookService.findByTitle(title);
    }

    @GetMapping(value = "/find-by-publishing")
    public List<BookDto> publishingSearch(@RequestParam String publishing) {
        return bookService.findByPublishing(publishing);
    }

    @GetMapping(value = "/find-by-year")
    public List<BookDto> yearSearch(@RequestParam Integer year) {
        return bookService.findByYear(year);
    }

    @GetMapping(value = "/find-by-author-name")
    public List<BookDto> authorNameSearch(@RequestParam String name) {
        return bookService.findByAuthorName(name);
    }

    @GetMapping(value = "/find-by-author-surname")
    public List<BookDto> authorSurnameSearch(@RequestParam String surname) {
        return bookService.findByAuthorSurname(surname);
    }

    @GetMapping(value = "/find-by-author-birthday")
    public List<BookDto> authorBirthdaySearch(@RequestParam
                                                  @DateTimeFormat(pattern = "yyyy-MM-dd",
                                                          iso = DateTimeFormat.ISO.DATE)
                                                  Date birthday) {
        return bookService.findByAuthorBirthday(birthday);
    }

    @GetMapping(value = "/find-by-author-gender")
    public List<BookDto> authorGenderSearch(@RequestParam
                                                @Pattern(regexp = "^([Mm]ale)|([Ff]emale)|([Uu]ndefined)")
                                                        String gender) {
        return bookService.findByAuthorGender(gender);
    }

    @GetMapping(value = "/advance-find")
    public List<BookDto> advanceSearch(@RequestParam String title,
                                       @RequestParam Integer year,
                                       @RequestParam String publishing,
                                       @RequestParam String name,
                                       @RequestParam String surname,
                                       @RequestParam String gender) {
        return bookService.findByAll(title, year, publishing, name, surname, gender);
    }


}
