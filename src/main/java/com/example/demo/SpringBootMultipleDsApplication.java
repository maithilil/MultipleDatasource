package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.api.model.book.Book;
import com.example.demo.api.model.user.User;
import com.example.demo.api.user.repository.UserRepository;
import com.example.demo.book.repository.BookRepository;

@SpringBootApplication
@RestController

public class SpringBootMultipleDsApplication {
	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void addToDB() {
		userRepository.saveAll(Stream.of(new User(744, "John"), new User(744, "John")).collect(Collectors.toList()));
		bookRepository
				.saveAll(Stream.of(new Book(10, "CoreJava"), new Book(11, "AdvanceJava")).collect(Collectors.toList()));
	}

	@GetMapping("/getUsers")
	public List<User> getUser() {
		return userRepository.findAll();
	}

	@GetMapping("/getBooks")
	public List<Book> getBook() {
		return bookRepository.findAll();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMultipleDsApplication.class, args);

	}

}
