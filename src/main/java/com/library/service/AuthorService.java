package com.library.service;

import com.library.dto.AuthorDto;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface AuthorService {

    AuthorDto saveAuthor(AuthorDto authorDto);

    AuthorDto editAuthor(Integer id, AuthorDto authorDto);

    void deleteAuthor(Integer id);

    AuthorDto findById(Integer id);

    List<AuthorDto> findAll();

    List<AuthorDto> findByName(String name);

    List<AuthorDto> findBySurname(String surname);

    List<AuthorDto> findByDate(Date date);

    List<AuthorDto> findByGender(String gender);
}
