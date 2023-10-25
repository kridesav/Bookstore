package hh.sof3.Bookstore;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.sof3.Bookstore.domain.Book;
import hh.sof3.Bookstore.domain.BookRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testCreateBook() {
        Book book = new Book("Sample Book", "Sample Author", 2023, "ISBN123456", 29.99, null);
        book = bookRepository.save(book);
        assertNotNull(book.getId());
    }

    @Test  
    public void findByTitleShouldReturnAuthor() {
        List<Book> books = bookRepository.findByTitle("To Kill a Mockingbird");
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("Harper Lee");
    }

    @Test
    public void testReadBook() {
        Book book = new Book("Sample Book", "Sample Author", 2023, "ISBN123456", 29.99, null);
        book = bookRepository.save(book);
        Book retrievedBook = bookRepository.findById(book.getId()).orElse(null);
        assertNotNull(retrievedBook);
        assertEquals(book.getId(), retrievedBook.getId());
        assertEquals(book.getTitle(), retrievedBook.getTitle());
        assertEquals(book.getAuthor(), retrievedBook.getAuthor());
        assertEquals(book.getYear(), retrievedBook.getYear());
        assertEquals(book.getIsbn(), retrievedBook.getIsbn());
        assertEquals(book.getPrice(), retrievedBook.getPrice(), 0.001);
    }

    @Test
    public void testUpdateBook() {
        Book book = new Book("Sample Book", "Sample Author", 2023, "ISBN123456", 29.99, null);
        book = bookRepository.save(book);
        book.setTitle("Updated Title");
        bookRepository.save(book);
        Book updatedBook = bookRepository.findById(book.getId()).orElse(null);
        assertNotNull(updatedBook);
        assertEquals("Updated Title", updatedBook.getTitle());
    }

    @Test
    public void testDeleteBook() {
        Book book = new Book("Sample Book", "Sample Author", 2023, "ISBN123456", 29.99, null);
        book = bookRepository.save(book);
        bookRepository.delete(book);
        assertFalse(bookRepository.findById(book.getId()).isPresent());
    }
}