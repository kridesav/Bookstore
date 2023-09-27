package hh.sof3.Bookstore.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.sof3.Bookstore.domain.Category;
import hh.sof3.Bookstore.domain.CategoryRepository;


// http://localhost:8080/

@Controller
public class CategoryController {
    @Autowired
    private CategoryRepository cRepo;

    
    @RequestMapping(value = { "/categorylist" })
    public String categoryList(Model model) {
        model.addAttribute("categories", cRepo.findAll());
        return "categorylist";
    }

    @RequestMapping(value = "/addcategory")
    public String addcategory(Model model) {
        model.addAttribute("Category", new Category());
        return "addcategory";
    }

    @RequestMapping(value = "/savecategory", method = RequestMethod.POST)
    public String save(Category category) {
        cRepo.save(category);
        return "redirect:/categorylist";
    }

    @RequestMapping(value = "/editcategory/edit", method = RequestMethod.POST)
    public String saveEdit (Category category) {
        cRepo.save(category);
        return "redirect:/categorylist";
    }

    @RequestMapping(value = "/deletecategory/{id}", method = RequestMethod.GET)
    public String deleteCategory(@PathVariable("id") Long categoryId, Model model) {
        cRepo.deleteById(categoryId);
        return "redirect:/categorylist";
    }

    @RequestMapping(value = "/editcategory/{id}", method = RequestMethod.GET)
    public String editCategory(@PathVariable("id") Long categoryId, Model model) {
        Optional<Category> category = cRepo.findById(categoryId);
        if (category.isPresent()) {
            model.addAttribute("Category", category.get());
            return "editcategory";
        } else {
            return "redirect:/categorylist";
        }
    }

}
