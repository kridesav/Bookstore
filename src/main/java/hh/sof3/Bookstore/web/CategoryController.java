package hh.sof3.Bookstore.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.sof3.Bookstore.domain.Book;
import hh.sof3.Bookstore.domain.BookRepository;
import hh.sof3.Bookstore.domain.CategoryRepository;

// http://localhost:8080/

@Controller
public class CategoryController {
    @Autowired
    private CategoryRepository repository;

}
