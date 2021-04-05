package com.library.service;

import com.library.dto.AuthorDto;
import com.library.model.Author;
import com.library.repository.AuthorRepository;
import com.library.utils.AuthorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public AuthorDto saveAuthor(AuthorDto authorDto) {
        Author savedAuthor = authorRepository.save(AuthorMapper.mapToAuthorEntity(authorDto));
        return AuthorMapper.mapToAuthorDto(savedAuthor);
    }

    @Override
    public AuthorDto editAuthor(Integer id, AuthorDto authorDto) {
        Optional<Author> authorOptional = authorRepository.findById(id);
        Author author = authorOptional.get();
        author.setName(authorDto.getName());
        author.setSurname(authorDto.getSurname());
        author.setBirthday(authorDto.getBirthday());
        author.setGender(authorDto.getGender());
        return AuthorMapper.mapToAuthorDto(authorRepository.save(author));
    }

    @Override
    public void deleteAuthor(Integer id) {

        authorRepository.deleteById(id);
    }

    @Override
    public AuthorDto findById(Integer id) {
        Optional<Author> author = authorRepository.findById(id);
        if (author.isPresent()) {
            return AuthorMapper.mapToAuthorDto(author.get());
        } else {
            return new AuthorDto();
        }
    }

    @Override
    public List<AuthorDto> findAll() {
        return authorRepository.findAll().stream()
                .map(AuthorMapper::mapToAuthorDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AuthorDto> findByName(String name) {
        return authorRepository.findAuthorByName(name).stream()
                .map(AuthorMapper::mapToAuthorDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AuthorDto> findBySurname(String surname) {
        return authorRepository.findAuthorBySurname(surname).stream()
                .map(AuthorMapper::mapToAuthorDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AuthorDto> findByDate(Date date) {
        return authorRepository.findAuthorByBirthday(date).stream()
                .map(AuthorMapper::mapToAuthorDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AuthorDto> findByGender(String gender) {
        return authorRepository.findAuthorByGender(gender).stream()
                .map(AuthorMapper::mapToAuthorDto)
                .collect(Collectors.toList());
    }
}
