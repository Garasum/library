package com.example.library;

import com.example.library.domain.Book;
import com.example.library.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class LibraryApplication {

    @Autowired
    private BookRepository bookRepository;

    @Component
    class DataSetup implements ApplicationRunner {
        @Override
        public void run(ApplicationArguments args) throws Exception {
            bookRepository.save(Book.builder().title("Gone with the Wind").isbn("12345").build());
            bookRepository.save(Book.builder().title("Effective Java").isbn("45678").build());
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
    }

}
