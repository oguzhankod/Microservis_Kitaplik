package com.kitaplik.bookservice;

import com.kitaplik.bookservice.model.Book;
import com.kitaplik.bookservice.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


import java.util.Arrays;
import java.util.List;


@SpringBootApplication
@EnableDiscoveryClient
public class BookServiceApplication implements CommandLineRunner {


	private final BookRepository bookRepository;

	public BookServiceApplication(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Book book1=new Book(1L,"Beyaz Dis",2000,"ABC yayınevi","123456");
		Book book2 = new Book(2L,"Hobbit", 2001, "Can Yayınları", "456789");
		Book book3 = new Book(3L,"Suc ve ceza", 2004, "YKB Yayınları", "987654");

		List<Book> bookList=bookRepository.saveAll(Arrays.asList(book1,book2,book3));

		System.out.println(bookList);
	}
}
