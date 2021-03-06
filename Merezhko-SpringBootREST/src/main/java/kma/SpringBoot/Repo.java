package kma.SpringBoot;

import org.springframework.stereotype.Component;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class Repo {
    private static final Map<String, Book> repository = new HashMap<>();;

    public List<Book> allItems(){
        return repository.values().stream().sorted(Comparator.comparing(Book::getIsbn)).collect(Collectors.toList());
    }

    public List<Book> searchRequest(String book) {
        return repository.values().stream().filter(b->b.getIsbn().toLowerCase().contains(book.toLowerCase())||b.getTitle().toLowerCase().contains(book.toLowerCase())).sorted(Comparator.comparing(Book::getIsbn)).collect(Collectors.toList());
    }

    public Book saveNewBook(final Model newBook) {
        final Book book =  Book.builder().isbn(newBook.getIsbn()).title(newBook.getTitle()).author(newBook.getAuthor()).build();
        repository.put(book.getIsbn(), book);
        return book;
    }
}
