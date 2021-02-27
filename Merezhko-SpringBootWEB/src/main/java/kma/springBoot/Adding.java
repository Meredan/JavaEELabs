package kma.springBoot;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Adding {
    private final Repo bookRepo;

    @Autowired
    public Adding(Repo repo) {
        this.bookRepo = repo;
    }

    @GetMapping("/")
    public String getMainPage() {
        return "addform";
    }

    @PostMapping("/book")
    public String addBook(@ModelAttribute Model model) {
        Book book = new Book();
        BeanUtils.copyProperties(model, book);
        bookRepo.save(book);
        return "redirect:/books";
    }

    @GetMapping("/books")
    public String getBooks(org.springframework.ui.Model model) {
        model.addAttribute("books", bookRepo.findAll());
        return "booksrepo";
    }
}


