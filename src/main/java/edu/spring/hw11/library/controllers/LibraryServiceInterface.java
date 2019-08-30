package edu.spring.hw11.library.controllers;

import edu.spring.hw11.library.models.Author;
import edu.spring.hw11.library.models.Book;

import java.util.List;

public interface LibraryServiceInterface {

    List<Author> addAuthor(int id, String fName, String lName);
    List<Author> deleteAuthor(int id);
    List<Book> addBook(int id, String title, String genre, String description, int rate);
    List<Book> deleteBook(int id);
    void addBookToAuthor(int authorId, Book book);
    List<Book> sortBookByAuthor(int authorId);
    List<Book> sortBookByGenre(String genre);
    Book updateBook(int bookId, int updateBookId);
    Author updateAuthor(int authorId, int updateAuthorId);
}
