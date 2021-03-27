package com.example;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    //private final EntityManager entityManager;

    private final Repository repository;
    @Transactional
    public void createBook(final Book book) {
        repository.saveAndFlush(book);
    }


    @Transactional
    public Book getBookById(int id) {
        Optional<Book> optionalBook = repository.findById(id);
        return optionalBook.orElse(null);
    }

    @Transactional
    public List<Book> findAllBooks() {
        return repository.findAll();

    }
    @Transactional
    public List<Book> findAllByTitle(String title) {

        return repository.findAllByTitle(title);
    }
    @Transactional
    public List<Book> findAllByIsbn(String name) {

        return repository.findAllByIsbn(name);
    }
    @Transactional
    public List<Book> findAllByAuthor(String name) {
        return repository.findAllByAuthor(name);
    }
    @Transactional
    public List<Book> findAllByNameOrIsbn(String name) {
        return repository.findAllByIsbnOrName(name);
    }


}
