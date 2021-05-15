package library.controllers;

import library.dto.BookDto;
import library.model.Book;
import library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookDto> getAll() {
     return bookService.findAllBooks();
    }

    @GetMapping(value = "/{id}")
    public BookDto getById(@PathVariable("id") int id) {
        return bookService.findBook(id);
    }

/*    @PostMapping("/add")
    public BookDto addBook(@RequestBody BookDto book) {
        // TODO: map dto to book
        return bookService.saveBook(book);
    }*/

}