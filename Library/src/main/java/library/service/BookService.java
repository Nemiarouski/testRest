package library.service;

import library.dao.BookDAO;
import library.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {
    private BookDAO bookDAO;

    @Autowired
    public BookService(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
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

    public List<Book> findAllBooks() {
        return bookDAO.findAll();
    }
}