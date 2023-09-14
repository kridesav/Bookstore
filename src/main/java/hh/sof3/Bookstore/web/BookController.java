package hh.sof3.Bookstore.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hh.sof3.Bookstore.domain.Book;
import hh.sof3.Bookstore.domain.BookRepository;

// http://localhost:8080/index

@Controller
public class BookController {
    private final List<Book> books = new ArrayList<>();

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("books", books);
        return "index";
    };

    @Autowired
    private BookRepository repository;

    @RequestMapping(value = { "/", "/booklist" })
    public String bookList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
    };

    @PostMapping("/addBook")
    public String addBook(@RequestParam String title, @RequestParam String author, @RequestParam int year,
            @RequestParam String isbn, @RequestParam int price) {
        return "redirect:/index";
    };
}
