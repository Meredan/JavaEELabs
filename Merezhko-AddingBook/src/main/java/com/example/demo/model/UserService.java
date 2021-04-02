package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Setter
@Getter
@ToString
public class UserService {


    private Integer id;

    @NotEmpty(message = "login cannot be empty")
    private String login;

    @NotEmpty(message = "password cannot be empty")
    private String password;

    @NotNull(message = "auth field cannot be empty")
    private String customAuthField;
}
