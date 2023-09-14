package hh.sof3.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof3.Bookstore.domain.Book;
import hh.sof3.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	};

	@Bean
	public CommandLineRunner demo(BookRepository repository) {
	return (args) -> {
		
		Book b1 = new Book("Testikirja1", "Testi", 1999, "ISBN-Testi", 20);
		Book b2 = new Book("Testikirja2", "Testi2", 1995, "ISBN-Testi2", 30);
		Book b3 = new Book("Testikirja3", "Testi3", 1991, "ISBN-Testi3", 50);

		repository.save(b1);
		repository.save(b2);
		repository.save(b3);
	};
	}
}
