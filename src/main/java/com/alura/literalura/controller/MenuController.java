package com.alura.literalura.controller;

import com.alura.literalura.model.Book;
import com.alura.literalura.service.BookService;
import com.alura.literalura.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Scanner;

@Controller
public class MenuController {

    private final BookService bookService;

    @Autowired
    public MenuController(BookService bookService) {
        this.bookService = bookService;
    }

    public void startMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Escolha um número de sua opção:");
            System.out.println("1 - Buscar livro pelo título");
            System.out.println("2 - Listar livros registrados");
            System.out.println("3 - Listar autores registrados");
            System.out.println("4 - Listar autores vivos em um determinado ano");
            System.out.println("5 - Listar livros em um determinado idioma");
            System.out.println("0 - Sair");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("Digite o título do livro:");
                    String title = scanner.nextLine();
                    List<Book> books = bookService.searchAndSaveBooks(title);
                    books.forEach(book -> {
                        System.out.println("-------- LIVRO ---------");
                        System.out.println("Título: " + book.getTitle());
                        System.out.println("Autor: " + book.getAuthor().getName());
                        System.out.println("Idioma: " + book.getLanguage());
                        System.out.println("Número de Downloads: " + book.getDownloadCount());
                        System.out.println("-------------------------");
                    });
                    break;
                case 2:
                    List<Book> registeredBooks = bookService.listAllBooks();
                    registeredBooks.forEach(book -> {
                        System.out.println("-------- LIVRO ---------");
                        System.out.println("Título: " + book.getTitle());
                        System.out.println("Autor: " + book.getAuthor().getName());
                        System.out.println("Idioma: " + book.getLanguage());
                        System.out.println("Número de Downloads: " + book.getDownloadCount());
                        System.out.println("-------------------------");
                    });
                    break;
                case 3:
                    List<Author> registeredAuthors = bookService.listAllAuthors();
                    registeredAuthors.forEach(author -> {
                        System.out.println("-------- AUTOR ---------");
                        System.out.println("Nome: " + author.getName());
                        System.out.println("Ano de Nascimento: " + author.getBirthYear());
                        System.out.println("Ano de Falecimento: " + author.getDeathYear());
                        System.out.println("-------------------------");
                    });
                    break;
                case 4:
                    System.out.println("Digite o ano:");
                    int year = scanner.nextInt();
                    List<Author> aliveAuthors = bookService.listAuthorsAliveInYear(year);
                    aliveAuthors.forEach(author -> {
                        System.out.println("-------- AUTOR ---------");
                        System.out.println("Nome: " + author.getName());
                        System.out.println("Ano de Nascimento: " + author.getBirthYear());
                        System.out.println("Ano de Falecimento: " + author.getDeathYear());
                        System.out.println("-------------------------");
                    });
                    break;
                case 5:
                    System.out.println("Escolha um idioma:");
                    System.out.println("es - espanhol");
                    System.out.println("en - inglês");
                    System.out.println("fr - francês");
                    System.out.println("pt - português");
                    String language = scanner.nextLine();
                    List<Book> booksByLanguage = bookService.listBooksByLanguage(language);
                    booksByLanguage.forEach(book -> {
                        System.out.println("-------- LIVRO ---------");
                        System.out.println("Título: " + book.getTitle());
                        System.out.println("Autor: " + book.getAuthor().getName());
                        System.out.println("Idioma: " + book.getLanguage());
                        System.out.println("Número de Downloads: " + book.getDownloadCount());
                        System.out.println("-------------------------");
                    });
                    break;
                case 0:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

}
