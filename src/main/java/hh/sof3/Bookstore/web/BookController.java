package hh.sof3.Bookstore.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hh.sof3.Bookstore.domain.Book;

// http://localhost:8080/index

@Controller
public class BookController {
    private final List<Book> books = new ArrayList<>();

    @RequestMapping(value="/index", method=RequestMethod.GET)
    public String index (Model model) {
        model.addAttribute("books", books);
        return "index";
    };
    @PostMapping("/addBook")
	public String addBook(@RequestParam String title, @RequestParam String author) {
		books.add(new Book(title, author));
		return "redirect:/index";
    };
}
