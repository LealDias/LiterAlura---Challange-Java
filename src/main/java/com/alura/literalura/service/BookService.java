package com.alura.literalura.service;

import com.alura.literalura.model.Author;
import com.alura.literalura.model.Book;
import com.alura.literalura.repository.AuthorRepository;
import com.alura.literalura.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final GutendexApiService gutendexApiService;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, GutendexApiService gutendexApiService) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.gutendexApiService = gutendexApiService;
    }

    public List<Book> searchAndSaveBooks(String title) {
        List<Book> books = gutendexApiService.searchBooksByTitle(title);
        for (Book book : books) {
            if (book.getAuthor() != null) {
                Author author = book.getAuthor();
                Author existingAuthor = authorRepository.findByName(author.getName());
                if (existingAuthor == null) {
                    // Salva o autor antes de associar ao livro
                    existingAuthor = authorRepository.save(author);
                }
                book.setAuthor(existingAuthor);
                bookRepository.save(book);
            } else {
                System.out.println("Book without author: " + book.getTitle());
            }
        }
        return books;
    }

    public List<Book> listAllBooks() {
        return bookRepository.findAll();
    }

    public List<Author> listAllAuthors() {
        return authorRepository.findAll();
    }

    public List<Author> listAuthorsAliveInYear(int year) {
        return authorRepository.findAll().stream()
                .filter(author -> {
                    Integer birthYear = author.getBirthYear();
                    Integer deathYear = author.getDeathYear();
                    return (birthYear != null && birthYear <= year) &&
                            (deathYear == null || deathYear >= year);
                })
                .collect(Collectors.toList());
    }

    public List<Book> listBooksByLanguage(String language) {
        return bookRepository.findByLanguage(language);
    }
}