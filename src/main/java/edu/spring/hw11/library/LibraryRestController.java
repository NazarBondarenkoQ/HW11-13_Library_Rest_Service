package edu.spring.hw11.library;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@AllArgsConstructor
@RestController
public class LibraryRestController {

    LibraryServiceInterface libraryServiceInterface;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List<Book> sortedBookByAuthor(@PathVariable("id") int id) {
        return libraryServiceInterface.sortBookByAuthor(id);
    }

    @RequestMapping(value = "/{genre}/get", method = RequestMethod.GET)
    public List<Book> sortedBookByGenre(@PathVariable("genre") String genre) {
        return libraryServiceInterface.sortBookByGenre(genre);
    }


    @RequestMapping(value = "/author", method = RequestMethod.POST)
    public List<Author> addAuthor(
            @RequestParam(value = "authorId") int authorId,
            @RequestParam(value = "authorFName") String authorFName,
            @RequestParam(value = "authorLName") String authorLName
    ) {
        return libraryServiceInterface.addAuthor(authorId, authorFName, authorLName);
    }

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public List<Book> addBook(
            @RequestParam(value = "bookId") int bookId,
            @RequestParam(value = "bookTitle") String bookTitle,
            @RequestParam(value = "bookGenre") String bookGenre,
            @RequestParam(value = "bookDesc") String bookDesc,
            @RequestParam(value = "bookRate") int bookRate
    ) {
        return libraryServiceInterface.addBook(bookId, bookTitle, bookGenre, bookDesc, bookRate);
    }

    @RequestMapping(value = "/author/book", method = RequestMethod.PUT)
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

    @RequestMapping(value = "/author/{id}", method = RequestMethod.DELETE)
    public List<Author> deleteAuthor(@PathVariable("id") int authorId) {
        return libraryServiceInterface.deleteAuthor(authorId);
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.DELETE)
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


