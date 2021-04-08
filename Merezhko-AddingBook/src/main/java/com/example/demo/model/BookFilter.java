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
    @Pattern(regexp = "^(?:ISBN(?:-10)?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$)[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$",
            message = "ISBN is invalid")
    private String isbn;

    @NotEmpty(message = "Author cannot be empty")
    private String author;

}