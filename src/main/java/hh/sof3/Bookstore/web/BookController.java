package hh.sof3.Bookstore.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.sof3.Bookstore.domain.Book;
import hh.sof3.Bookstore.domain.BookRepository;
import hh.sof3.Bookstore.domain.CategoryRepository;

// http://localhost:8080/

@Controller
public class BookController {
    @Autowired
    private BookRepository repository;

    @Autowired
    private CategoryRepository cRepo;

    @RequestMapping(value = { "/", "/booklist" })
    public String bookList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }

    @RequestMapping(value = "/addbook")
    public String addbook(Model model) {
        model.addAttribute("categories", cRepo.findAll());
        model.addAttribute("Book", new Book());
        return "addbook";
    }

    @RequestMapping(value = "/savebook", method = RequestMethod.POST)
    public String save(Book book) {  
        repository.save(book);
        return "redirect:/booklist";
    }

    @RequestMapping(value = "/editbook/edit", method = RequestMethod.POST)
    public String saveEdit (Book book) {
        repository.save(book);
        return "redirect:/booklist";
    }

    @RequestMapping(value = "/deletebook/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
        repository.deleteById(bookId);
        return "redirect:/booklist";
    }

    @RequestMapping(value = "/editbook/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable("id") Long bookId, Model model) {
        Optional<Book> book = repository.findById(bookId);
        if (book.isPresent()) {
            model.addAttribute("Book", book.get());
            return "editbook";
        } else {
            return "redirect:/booklist";
        }
    }

    // Hakee kaikki kirjat taulusta ja palauttaa ne koodilla 200
	@GetMapping("/books")
	public ResponseEntity<Iterable<Book>> bookListRest() {
		Iterable<Book> books = repository.findAll();
		return new ResponseEntity<Iterable<Book>>(books, HttpStatus.OK);
	}

	// Etsii annettulla ID:llä kirjaa, palauttaa löydetyn kirja ja koodin 200
	// tai tyhjän bodyn koodilla 404
	@GetMapping("/books/{id}")
	public ResponseEntity<Optional<Book>> findBookRest(@PathVariable("id") Long id) {
		Optional<Book> book = repository.findById(id);
		if (book.isPresent()) {
			return new ResponseEntity<Optional<Book>>(book, HttpStatus.OK);
		} else {
			return new ResponseEntity<Optional<Book>>(HttpStatus.NOT_FOUND);
		}
	}

}
