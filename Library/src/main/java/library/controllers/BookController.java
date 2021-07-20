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

    @GetMapping("/all")
    public List<BookDto> getAll() {
        return bookService.getAll().stream()
                .map(bookMapper::mapToDto)
                .collect(Collectors.toList());
    }
    @GetMapping
    public List<Book> getAll1() {
        return bookService.getAll();
    }

    @GetMapping(value = "/{id}")
    public BookDto getById(@PathVariable("id") int id) {
        return bookMapper.mapToDto(bookService.getById(id));
    }

    @PostMapping("/add")
    public BookDto addBook(@RequestBody BookDto bookDto) {
        Book book = bookService.addBook(bookMapper.mapToBook(bookDto));
        return bookMapper.mapToDto(book);
    }

/*    @PostMapping("/add")
    public BookDto addBook(@RequestBody BookDto book) {
        // TODO: map dto to book
        return bookService.saveBook(book);
    }*/

}