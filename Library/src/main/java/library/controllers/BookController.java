package library.controllers;

import library.dto.BookDto;
import library.mappers.BookMapper;
import library.model.Book;
import library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {
    private BookService bookService;
    private BookMapper bookMapper;

    @Autowired
    public BookController(BookService bookService, BookMapper bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @GetMapping
    public List<BookDto> getAll() {
        return bookService.findAllBooks().stream()
                .map(bookMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}")
    public BookDto getById(@PathVariable("id") int id) {
        return bookMapper.mapToDto(bookService.findBook(id));
    }

    @PostMapping("/add")
    public BookDto addBook(@RequestBody BookDto bookDto) {
        Book book = bookService.saveBook(bookMapper.mapToBook(bookDto));
        return bookMapper.mapToDto(book);
    }

/*    @PostMapping("/add")
    public BookDto addBook(@RequestBody BookDto book) {
        // TODO: map dto to book
        return bookService.saveBook(book);
    }*/

}