package kma.SpringBoot;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class BookService {
    private final Adding service;
    public BookService(Adding service) {
        this.service = service;
    }

    @GetMapping(value = "/books")
    public List<Book> booksList(@RequestParam(name = "search", required = false) String search) {
        if(search!=null)
            return service.getSearchedBooks(search);
        return service.getAllBooks();
    }

    @PostMapping(value = "/addBook")
    public ResponseEntity addNewBook(@Validated @RequestBody final Model newBook) {
        try{
            service.createNewBook(newBook);
        }catch (Exception e){
            return ResponseEntity.status(400).body(e.getMessage());
        }
        return ResponseEntity.ok().build();
    }

}
