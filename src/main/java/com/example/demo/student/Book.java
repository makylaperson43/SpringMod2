package com.example.demo.student;

import javax.persistence.*;
import java.time.*;

@Entity
@Table
public class Book {

    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    private Long id;
    private String name;
    private String author;
    private String genre;
    private LocalDate releaseDate;
    @Transient
    private Integer bookAge;

    public Book() {
    }

    public Book(Long id,
                String name,
                String author,
                String genre,
                LocalDate releaseDate) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.genre = genre;
    }

    public Book(String name,
                String author,
                String genre,
                LocalDate releaseDate) {
        this.name = name;
        this.author = author;
        this.releaseDate = releaseDate;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getBookAge() {
        return Period.between(this.releaseDate, LocalDate.now()).getYears();
    }

    public void setBookAge(Integer bookAge) {
        this.bookAge = bookAge;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", releaseDate=" + releaseDate +
                ", bookAge=" + bookAge +
                '}';
    }
}
