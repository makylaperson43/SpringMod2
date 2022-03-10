package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public void addNewBook(Book book) {
         Optional<Book> bookOptional = bookRepository
                 .findBookByName(book.getName());
         if (bookOptional.isPresent()){
             throw new IllegalStateException("book name taken");
         }
         bookRepository.save(book);
    }

    public void deleteBook(Long bookId) {
        boolean exists = bookRepository.existsById(bookId);
        if(!exists) {
            throw new IllegalStateException(
                    "book with id " + bookId + " does not exists");
        }
        bookRepository.deleteById(bookId);
    }

    @Transactional
    public void updateBook(Long bookId,
                              String name,
                              String author,
                              String genre) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalStateException(
                        "book with id " + bookId + " does not exist"));

        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(book.getName(), name)){
            book.setName(name);
        }

        if(author != null &&
                author.length() > 0 &&
                !Objects.equals(book.getAuthor(), author)){
            book.setAuthor(author);
        }

        if(genre != null &&
                genre.length() > 0 &&
                !Objects.equals(book.getGenre(), genre)){
            book.setGenre(genre);
        }
    }

    public Optional<Book> getSpecificBook(Long bookId) {
        return bookRepository.findById(bookId);
    }
}
