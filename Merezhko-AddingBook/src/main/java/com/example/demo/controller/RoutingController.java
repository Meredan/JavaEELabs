package com.example.demo.controller;

import com.example.demo.model.BookEntity;
import com.example.demo.service.BookService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RoutingController {

    private final BookService bookService;

    public RoutingController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PreAuthorize("isFullyAuthenticated()")
    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }


    @GetMapping("/book_list")
    public String bookCatalog() {
        return "book_list";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/book/{bookId}")
    public String getData(@PathVariable("bookId") Integer bookId, Model model) {
        BookEntity book = bookService.getBookById(bookId);
        model.addAttribute("book", book);
        return "book_page";
    }
}
