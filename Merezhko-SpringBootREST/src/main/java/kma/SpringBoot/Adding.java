package kma.SpringBoot;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Adding {
    private final Repo repo;


    public boolean createNewBook(final Model newBook) {
        final Book book = repo.saveNewBook(newBook);
        return true;
    }

    public List<Book> getAllBooks() {
        return repo.allItems();
    }

    public List<Book> getSearchedBooks(String search) {
        return repo.searchRequest(search);
    }
}
