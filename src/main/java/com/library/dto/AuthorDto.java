package com.library.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class AuthorDto {
    private Integer id;

    @NotNull
    @NotBlank(message = "author's name can't be blank")
    @Size(min=1, max = 16)
    @Pattern(message = "Bad formed person name: ${validatedValue}",
            regexp = "^[a-zA-Z][a-zA-Z0-9-_\\.]{1,16}$")
    private String name;

    @NotNull
    @NotBlank(message = "author's surname can't be blank")
    @Size(min=1, max = 16)
    @Pattern(message = "Bad formed person surname: ${validatedValue}",
            regexp = "^[a-zA-Z][a-zA-Z0-9-_\\.]{1,16}$")
    private String surname;

    @Temporal(TemporalType.DATE)
    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date birthday;

    @NotNull
    @NotBlank(message = "author's gender can't be blank")
    @Pattern(message = "Bad formed person gender: ${validatedValue}",
            regexp = "^([Mm]ale)|([Ff]emale)|([Uu]ndefined)")
    private String gender;

}
