package hh.sof3.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof3.Bookstore.domain.Book;
import hh.sof3.Bookstore.domain.BookRepository;
import hh.sof3.Bookstore.domain.Category;
import hh.sof3.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	};

	@Bean
	public CommandLineRunner demo(BookRepository bRepo, CategoryRepository cRepo) {
		return (args) -> {

			Book book1 = new Book();
			book1.setTitle("To Kill a Mockingbird");
			book1.setAuthor("Harper Lee");
			book1.setYear(1960);
			book1.setIsbn("9780061120084");
			book1.setPrice(12.99);

			Book book2 = new Book();
			book2.setTitle("1984");
			book2.setAuthor("George Orwell");
			book2.setYear(1949);
			book2.setIsbn("9780451524935");
			book2.setPrice(9.99);

			Book book3 = new Book();
			book3.setTitle("Pride and Prejudice");
			book3.setAuthor("Jane Austen");
			book3.setYear(1813);
			book3.setIsbn("9780141439518");
			book3.setPrice(10.99);

			Book book4 = new Book();
			book4.setTitle("Moby-Dick");
			book4.setAuthor("Herman Melville");
			book4.setYear(1851);
			book4.setIsbn("9781853260087");
			book4.setPrice(14.99);

			Book book5 = new Book();
			book5.setTitle("The Great Gatsby");
			book5.setAuthor("F. Scott Fitzgerald");
			book5.setYear(1925);
			book5.setIsbn("9780743273565");
			book5.setPrice(11.99);

			Book book6 = new Book();
			book6.setTitle("War and Peace");
			book6.setAuthor("Leo Tolstoy");
			book6.setYear(1869);
			book6.setIsbn("9780199232765");
			book6.setPrice(18.99);

			Book book7 = new Book();
			book7.setTitle("The Catcher in the Rye");
			book7.setAuthor("J.D. Salinger");
			book7.setYear(1951);
			book7.setIsbn("9780316769174");
			book7.setPrice(9.95);

			Category category1 = new Category();
			category1.setName("scifi");

			Category category2 = new Category();
			category2.setName("comedy");

			Category category3 = new Category();
			category3.setName("fantasy");

			Category category4 = new Category();
			category4.setName("thriller");

			Category category5 = new Category();
			category5.setName("drama");

			bRepo.save(book1);
			bRepo.save(book2);
			bRepo.save(book3);
			bRepo.save(book4);
			bRepo.save(book5);
			bRepo.save(book6);
			bRepo.save(book7);

			cRepo.save(category1);
			cRepo.save(category2);
			cRepo.save(category3);
			cRepo.save(category4);
			cRepo.save(category5);

		};
	}
}
