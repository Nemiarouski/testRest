package library.service;

import library.mappers.BookMapper;
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
    private final BookMapper bookMapper;

    @Autowired
    public BookService(BookDAO bookDAO, BookMapper bookMapper) {
        this.bookDAO = bookDAO;
        this.bookMapper = bookMapper;
    }

    public BookDto findBook(int id) {
        //return bookDAO.findById(id);
        return bookMapper.mapToBookDto(bookDAO.findById(id));
    }
    public Book findBookEn(int id) {
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
                .map(bookMapper::mapToBookDto)
                .collect(Collectors.toList());
    }
}