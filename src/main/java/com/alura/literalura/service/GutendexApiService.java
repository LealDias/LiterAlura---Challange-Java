package com.alura.literalura.service;


import com.alura.literalura.model.Author;
import com.alura.literalura.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GutendexApiService {

    private final RestTemplate restTemplate;

    @Autowired
    public GutendexApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Book> searchBooksByTitle(String title) {
        String url = "https://gutendex.com/books?search=" + title;
        GutendexResponse response = restTemplate.getForObject(url, GutendexResponse.class);

        System.out.println("API Response: " + response);

        if (response != null && response.getResults() != null) {
            // Filtrar os resultados para garantir que o título contém o termo buscado
            List<GutendexBook> filteredResults = response.getResults().stream()
                    .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()))
                    .collect(Collectors.toList());

            System.out.println("Filtered Results: " + filteredResults);

            return mapGutendexBooksToBooks(filteredResults);
        } else {
            System.out.println("No results found for the title: " + title);
        }
        return new ArrayList<>();
    }

    private List<Book> mapGutendexBooksToBooks(List<GutendexBook> gutendexBooks) {
        List<Book> books = new ArrayList<>();
        for (GutendexBook gutendexBook : gutendexBooks) {
            if (gutendexBook == null || gutendexBook.getAuthors() == null || gutendexBook.getAuthors().isEmpty()) {
                System.out.println("Skipping book due to missing author information: " + gutendexBook.getTitle());
                continue; // Ignore books without author information
            }

            GutendexAuthor gutendexAuthor = gutendexBook.getAuthors().get(0);
            if (gutendexAuthor == null || gutendexAuthor.getName() == null) {
                System.out.println("Skipping book due to null author or author name: " + gutendexBook.getTitle());
                continue; // Ignore authors with null critical fields
            }

            Book book = new Book();
            book.setTitle(truncate(gutendexBook.getTitle(), 255));
            book.setLanguage(gutendexBook.getLanguages().get(0));
            book.setDownloadCount(gutendexBook.getDownloadCount());

            Author author = new Author();
            author.setName(truncate(gutendexAuthor.getName(), 255));
            author.setBirthYear(gutendexAuthor.getBirthYear());
            author.setDeathYear(gutendexAuthor.getDeathYear());
            book.setAuthor(author);

            System.out.println("Mapped Author: " + author.getName() + ", Birth Year: " + author.getBirthYear() + ", Death Year: " + author.getDeathYear());

            books.add(book);
        }
        System.out.println("Mapped Books: " + books);
        return books;
    }

    private String truncate(String value, int length) {
        if (value != null && value.length() > length) {
            return value.substring(0, length);
        }
        return value;
    }
}
