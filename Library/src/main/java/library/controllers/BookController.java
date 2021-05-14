package library.controllers;

import library.model.Book;
import library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAll() {
     return bookService.findAllBooks();
    }

/*    @PostMapping("/add")
    public BookDto addBook(@RequestBody BookDto book) {
        // TODO: map dto to book
        return bookService.saveBook(book);
    }*/

}