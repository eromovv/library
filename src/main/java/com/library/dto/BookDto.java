package com.library.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class BookDto {
    private Integer id;

    @NotNull
    @NotBlank(message = "book's title can't be blank")
    @Size(min=1, max = 60)
    @Pattern(message = "Bad formed title of a book: ${validatedValue}",
            regexp = "^[ a-zA-Z0-9-_\\.]{1,60}$")
    private String title;

    @Temporal(TemporalType.DATE)
    @NotNull
    @JsonFormat(pattern="yyyy")
    private Integer year;

    @NotNull
    @NotBlank(message = "book's publishing can't be blank")
    @Size(min=1, max = 60)
    @Pattern(message = "Bad formed publishing of a book: ${validatedValue}",
            regexp = "^[ a-zA-Z0-9-_\\.]{1,60}$")
    private String publishing;
}
