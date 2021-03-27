package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BookInfoBoot {
    static BookService bookService;
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(BookInfoBoot.class, args);
        bookService = applicationContext.getBean(BookService.class);
    }
}
