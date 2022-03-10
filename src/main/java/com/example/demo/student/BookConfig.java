package com.example.demo.student;

import org.springframework.boot.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class BookConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            BookRepository repository){
        return arg -> {
            Book theHateYouGive = new Book(
                    "The Hate You Give",
                    "Angie Thomas",
                    "Urban Fiction",
                    LocalDate.of(2018, SEPTEMBER, 7)
            );

            Book alex = new Book(
                    "Unfriended",
                    "Rachel Vail",
                    "Fiction",
                    LocalDate.of(2014, SEPTEMBER, 25)
            );

            repository.saveAll(
                    List.of(theHateYouGive, alex)
            );
        };
    }
}
