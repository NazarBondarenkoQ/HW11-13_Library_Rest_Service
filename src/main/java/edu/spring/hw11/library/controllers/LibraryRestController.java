package edu.spring.hw11.library.controllers;

import edu.spring.hw11.library.controllers.LibraryServiceInterface;
import edu.spring.hw11.library.models.Author;
import edu.spring.hw11.library.models.Book;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@AllArgsConstructor
@RestController
public class LibraryRestController {

    LibraryServiceInterface libraryServiceInterface;

    @ResponseBody
    @GetMapping("/{id}")
    public List<Book> sortedBookByAuthor(@PathVariable("id") int id) {
        return libraryServiceInterface.sortBookByAuthor(id);
    }

    @ResponseBody
    @GetMapping("/book/{genre}")
    public List<Book> sortedBookByGenre(@PathVariable("genre") String genre) {
        return libraryServiceInterface.sortBookByGenre(genre);
    }


    @ResponseBody
    @PostMapping("author/add")
    public List<Author> addAuthor(
            @RequestParam(value = "authorId") int authorId,
            @RequestParam(value = "authorFName") String authorFName,
            @RequestParam(value = "authorLName") String authorLName
    ) {
        return libraryServiceInterface.addAuthor(authorId, authorFName, authorLName);
    }

    @ResponseBody
    @PostMapping("book/add")
    public List<Book> addBook(
            @RequestParam(value = "bookId") int bookId,
            @RequestParam(value = "bookTitle") String bookTitle,
            @RequestParam(value = "bookGenre") String bookGenre,
            @RequestParam(value = "bookDesc") String bookDesc,
            @RequestParam(value = "bookRate") int bookRate
    ) {
        return libraryServiceInterface.addBook(bookId, bookTitle, bookGenre, bookDesc, bookRate);
    }

    @ResponseBody
    @PutMapping("book/add/author")
    public Map<Integer, Book> addBookToAuthor(
            @RequestParam(value = "authorId") int authorId,
            @RequestParam(value = "bookId") int bookId,
            @RequestParam(value = "bookTitle") String bookTitle,
            @RequestParam(value = "bookGenre") String bookGenre,
            @RequestParam(value = "bookDesc") String bookDesc,
            @RequestParam(value = "bookRate") int bookRate
    ) {
        Map<Integer, Book> map = new LinkedHashMap<>();
        Book book1 = new Book(bookId, bookTitle, bookGenre, bookDesc, bookRate);
        libraryServiceInterface.addBookToAuthor(authorId, book1);
        map.put(authorId, book1);
        return map;
    }

    @ResponseBody
    @DeleteMapping("author/{id}")
    public List<Author> deleteAuthor(@PathVariable("id") int authorId) {
        return libraryServiceInterface.deleteAuthor(authorId);
    }

    @ResponseBody
    @DeleteMapping("book/{id}")
    public List<Book> deleteBook(@PathVariable("id") int bookId) {
        return libraryServiceInterface.deleteBook(bookId);
    }

    @ResponseBody
    @PatchMapping("author/{id}")
    public Author updateAuthor(@RequestParam("id") int updateId, @PathVariable("id") int id) {
        return libraryServiceInterface.updateAuthor(id, updateId);
    }

    @ResponseBody
    @PatchMapping("book/{id}")
    public Book updateBook(@RequestParam("id") int updateId, @PathVariable("id") int id) {
        return libraryServiceInterface.updateBook(id, updateId);
    }
}


