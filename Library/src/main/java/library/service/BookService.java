package library.service;

import library.config.MappingConfig;
import library.dao.BookDAO;
import library.dto.BookDto;
import library.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    private BookDAO bookDAO;
    private final MappingConfig mappingConfig;

    @Autowired
    public BookService(BookDAO bookDAO, MappingConfig mappingConfig) {
        this.bookDAO = bookDAO;
        this.mappingConfig = mappingConfig;
    }

    public Book findBook(int id) {
        return bookDAO.findById(id);
    }

    public Book saveBook(Book book) {
        return bookDAO.save(book);
    }

    public void deleteBook(Book book) {
        bookDAO.delete(book);
    }

    public void updateBook(Book book) {
        bookDAO.update(book);
    }

    public List<BookDto> findAllBooks() {
       /* return bookDAO.findAll();*/
        return bookDAO.findAll().stream()
                .map(mappingConfig::mapToBookDto)
                .collect(Collectors.toList());
    }
}