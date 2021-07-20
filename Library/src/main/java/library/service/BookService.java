package library.service;

import library.dao.BookDAO;
import library.model.Book;
import library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {
    private BookDAO bookDAO;
    private BookRepository bookRepository;

    @Autowired
    public BookService(BookDAO bookDAO, BookRepository bookRepository) {
        this.bookDAO = bookDAO;
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book) {
        Book savedBook = bookRepository.saveAndFlush(book);
        return savedBook;
    }

    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    public Book getByName(String name) {
        return bookRepository.findByName(name);
    }

    public Book editBook(Book book) {
        return bookRepository.saveAndFlush(book);
    }

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public Book getById(int id) {
        return bookRepository.findById(id);
    }

/*    public Book findBook(int id) {
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
    }*/
}