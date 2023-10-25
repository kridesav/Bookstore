package hh.sof3.Bookstore;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.sof3.Bookstore.domain.Category;
import hh.sof3.Bookstore.domain.CategoryRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void testCreateCategory() {
        Category category = new Category("Sample Category");
        category = categoryRepository.save(category);
        assertNotNull(category.getId());
    }

    @Test
    public void findCategoriesByNameShouldReturnMatchingCategories() {
        Category category1 = new Category("Fiction");
        Category category2 = new Category("Science Fiction");
        Category category3 = new Category("Mystery");

        categoryRepository.save(category1);
        categoryRepository.save(category2);
        categoryRepository.save(category3);

        List<Category> foundCategories = categoryRepository.findByName("Fiction");

        assertThat(foundCategories).isNotEmpty();
        assertThat(foundCategories).contains(category1);
    }

    @Test
    public void testReadCategory() {
        Category category = new Category("Sample Category");
        category = categoryRepository.save(category);
        Category retrievedCategory = categoryRepository.findById(category.getId()).orElse(null);
        assertNotNull(retrievedCategory);
        assertEquals(category.getId(), retrievedCategory.getId());
        assertEquals(category.getName(), retrievedCategory.getName());
    }

    @Test
    public void testUpdateCategory() {
        Category category = new Category("Sample Category");
        category = categoryRepository.save(category);
        category.setName("Updated Category Name");
        categoryRepository.save(category);
        Category updatedCategory = categoryRepository.findById(category.getId()).orElse(null);
        assertNotNull(updatedCategory);
        assertEquals("Updated Category Name", updatedCategory.getName());
    }

    @Test
    public void testDeleteCategory() {
        Category category = new Category("Sample Category");
        category = categoryRepository.save(category);
        categoryRepository.delete(category);
        assertFalse(categoryRepository.findById(category.getId()).isPresent());
    }
}