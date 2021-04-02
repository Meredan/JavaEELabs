package com.example.demo.controller;

import com.example.demo.model.BookEntity;
import com.example.demo.model.BookFilter;
import com.example.demo.model.SearchFilter;
import com.example.demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;


    @RequestMapping(value = "/search", method = {RequestMethod.POST})
    public ResponseEntity<List<BookEntity>> bookControllerGetAllByTitle(@RequestBody final SearchFilter searchFilter) {
        return ResponseEntity.ok(bookService.findAllByCriteria(searchFilter.getSearchCriteria(), searchFilter.getSearchInput()));
    }

    @ResponseBody
    @GetMapping(value = "/books")
    public List<BookEntity> bookFormControllerGet() {
        return bookService.findAllBooks();
    }

    @PreAuthorize("hasAuthority('VIEW_ADMIN')")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<BookFilter> bookFormControllerPost(@Valid @RequestBody final BookFilter bookModel) {

        BookEntity bookEntity = bookService.createBook(bookModel.getTitle(), bookModel.getIsbn(), bookModel.getAuthor());
        BookFilter bookDTO = new BookFilter();
        bookDTO.setAuthor(bookEntity.getAuthor());
        bookDTO.setIsbn(bookEntity.getIsbn());
        bookDTO.setTitle(bookEntity.getTitle());
        return ResponseEntity.ok(bookDTO);
    }

    @RequestMapping(value = "/books/{bookId}")
    public ResponseEntity<BookEntity> getData(@PathVariable("bookId") Integer bookId) {
        return ResponseEntity.ok(bookService.getBookById(bookId));
    }

}
