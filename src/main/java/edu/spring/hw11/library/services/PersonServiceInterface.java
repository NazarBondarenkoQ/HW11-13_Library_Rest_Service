package edu.spring.hw11.library.services;

import edu.spring.hw11.library.NotFoundExceptions;
import edu.spring.hw11.library.controllers.LibraryServiceInterface;
import edu.spring.hw11.library.models.Author;
import edu.spring.hw11.library.models.Book;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PersonServiceInterface implements LibraryServiceInterface {
    private List<Book> bookList = new ArrayList<>(Arrays.asList(
            new Book(1, "1984", "Antiuthopia",
                    "Ignorance is Strength.", 5),
            new Book(2, "Thinking in Java", "Education",
                    "Thinking in Java should be read cover to cover by every Java programmer, then kept close at hand for frequent reference", 5),
            new Book(3, "The C++ Programming", "Education",
                    "Learn how to effectively code on C++", 3)));
    private List<Author> authorList = new ArrayList<>(Arrays.asList(
            new Author(1, "George", "Orwell",
                    new HashSet<Book>(bookList.subList(0, 1))),
            new Author(2, "Bruce", "Eckel",
                    new HashSet<Book>(bookList.subList(1, 2))),
            new Author(3, "Bjarne", "Stroustroup")));

    @Override
    public List<Author> addAuthor(int id, String fName, String lName) {
        Author author = new Author(id, fName, lName);
        authorList.add(author);
        return authorList;
    }

    @Override
    public List<Author> deleteAuthor(int id) {
        authorList.removeIf(a -> a.getId() == id);
        return authorList;
    }

    @Override
    public List<Book> addBook(int id, String title, String genre, String description, int rate) {
        Book book = new Book(id, title, genre, description, rate);
        bookList.add(book);
        return bookList;
    }

    @Override
    public List<Book> deleteBook(int id) {
        bookList.removeIf(b -> b.getId() == id);
        return bookList;
    }

    @Override
    public void addBookToAuthor(int authorId, Book book) {
        authorList.stream()
                .filter(a -> a.getId() == authorId)
                .findAny()
                .orElseThrow(() -> new RuntimeException("Item not found"))
                .setBook(book);
    }

    @Override
    public List<Book> sortBookByAuthor(int authorId) {
        return authorList.stream()
                .filter(a -> a.getId() == authorId)
                .flatMap(a -> a.getBook().stream())
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> sortBookByGenre(String genre) {
        return bookList.stream()
                .filter(b -> b.getGenre().equals(genre))
                .collect(Collectors.toList());
    }

    @Override
    public Book updateBook(int bookId, int updateBookId) {
        bookList.stream()
                .filter(b -> b.getId() == bookId)
                .forEach(b -> b.setId(updateBookId));
        return bookList.stream().filter(b -> b.getId() == updateBookId)
                .findAny().orElseThrow(NotFoundExceptions::new);
    }

    @Override
    public Author updateAuthor(int authorId, int updateAuthorId) {
        authorList.stream()
                .filter(a -> a.getId() == authorId)
                .forEach(b -> b.setId(updateAuthorId));
        return authorList.stream().filter(a -> a.getId() == updateAuthorId)
                .findAny().orElseThrow(NotFoundExceptions::new);
    }
}