package com.library.utils;

import com.library.dto.AuthorDto;
import com.library.model.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {

    public static Author mapToAuthorEntity(AuthorDto authorDto){
        Author author = new Author();
        author.setName(authorDto.getName());
        author.setSurname(authorDto.getSurname());
        author.setBirthday(authorDto.getBirthday());
        author.setGender(authorDto.getGender());
        return author;
    }

    public static AuthorDto mapToAuthorDto(Author author){
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(author.getId());
        authorDto.setName(author.getName());
        authorDto.setSurname(author.getSurname());
        authorDto.setBirthday(author.getBirthday());
        authorDto.setGender(author.getGender());
        return authorDto;
    }

}
