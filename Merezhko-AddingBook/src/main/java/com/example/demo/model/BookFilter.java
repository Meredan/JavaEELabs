package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
public class BookFilter {

    @NotEmpty(message = "Title cannot be empty")
    @Size(min = 2)
    private String title;

    @NotEmpty(message = "ISBN cannot be empty")
    private String isbn;

    @NotEmpty(message = "Author cannot be empty")
    private String author;

}
