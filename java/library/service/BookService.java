package library.service;

import library.dao.BookDAO;
import library.model.Book;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {
    private static BookDAO bookDAO;

    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public List<Book> allBooks() {
        return bookDAO.allBooks();
    }

    public void add(Book book) {
        bookDAO.add(book);
    }

    public void delete(Book book) {
        bookDAO.delete(book);
    }

    public void edit(Book book) {
        bookDAO.edit(book);
    }

    public Book getById(int id) {
        return bookDAO.getById(id);
    }
}