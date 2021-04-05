package com.library.controller;

import com.library.dto.AuthorDto;
import com.library.service.AuthorServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/authors")
@AllArgsConstructor
public class AuthorController {

    private final AuthorServiceImpl authorService;

    @PostMapping(value = "/save")
    public ResponseEntity<AuthorDto> save(@Validated @RequestBody AuthorDto authorDto) {
        AuthorDto authorDto1 = authorService.saveAuthor(authorDto);
        return new ResponseEntity<>(authorDto1, HttpStatus.OK);
    }

    @PutMapping(value = "/edit/{id}")
    public ResponseEntity<AuthorDto> edit(@PathVariable("id") Integer id,
                                          @Validated @RequestBody AuthorDto authorDto) {
        AuthorDto authorDto1 = authorService.editAuthor(id, authorDto);
        return new ResponseEntity<>(authorDto1, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public void delete(@PathVariable("id") Integer id) {
        authorService.deleteAuthor(id);
    }

    @GetMapping(value = "/find")
    public List<AuthorDto> find() {
        return authorService.findAll();
    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<AuthorDto> find(@PathVariable("id") Integer id) {
        AuthorDto authorDto = authorService.findById(id);
        return new ResponseEntity<>(authorDto, HttpStatus.OK);
    }

    @GetMapping(value = "/find-by-name")
    public List<AuthorDto> nameSearch(@RequestParam String name) {
        return authorService.findByName(name);
    }

    @GetMapping(value = "/find-by-surname")
    public List<AuthorDto> surnameSearch(@RequestParam String surname) {
        return authorService.findBySurname(surname);
    }

    @GetMapping(value = "/find-by-date")
    public List<AuthorDto> dateSearch(@RequestParam
                                          @DateTimeFormat(pattern = "yyyy-MM-dd",
                                                  iso = DateTimeFormat.ISO.DATE)
                                                  Date birthday) {
        return authorService.findByDate(birthday);
    }

    @GetMapping(value = "/find-by-gender")
    public List<AuthorDto> genderSearch(@RequestParam String gender) {
        return authorService.findByGender(gender);
    }

}
