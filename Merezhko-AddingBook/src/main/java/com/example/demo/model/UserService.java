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
    @Pattern(regexp = "^(?=.{1,30}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$", message = "Wrong login format")
    private String login;

    @NotEmpty(message = "password cannot be empty")
    @Pattern(regexp = "^(?=.{8,20}$)[a-zA-Z0-9._]+(?<![_.])$", message = "Wrong password format")
    private String password;

    @NotNull(message = "auth field cannot be empty")
    private String customAuthField;
}
