package library.controllers;

import library.model.Book;
import library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private static BookService bookService;

    private Book book;
    private List<Book> books = new ArrayList<>();

    @Autowired
    public static void setBookService(BookService bookService) {
        BookController.bookService = bookService;
    }

    {
        book = new Book();
        book.setName("John");
        book.setAuthor("King");
        book.setDescription("Sci-fi");
        books.add(book);
    }

    @GetMapping
    public String all() {
        return books.toString();
    }
}