package com.example;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Repository extends JpaRepository<Book, Integer> {
    @Query( "select u from Book u " +
            "where u.title like :name " +
            "or u.isbn like :name"
    )
    List<Book> findAllByIsbnOrName(@Param("name") String name);
    List<Book> findAllByAuthor(String author);
    List<Book> findAllByTitle(String title);
    List<Book> findAllByIsbn(String contains);




}