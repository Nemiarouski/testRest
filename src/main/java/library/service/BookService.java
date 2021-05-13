package library.service;

import library.model.Book;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class BookService {
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private List<Book> books = new ArrayList<>();

    public List<Book> allBooks() {
        return books;
    }

    public void add(Book book) {
        book.setId(AUTO_ID.getAndIncrement());
        books.add(book);
    }

    public void delete(Book book) {
        books.remove(book.getId());
    }

    public void edit(Book book) {
        books.add(book.getId(), book);
    }

    public Book getById(int id) {
        return books.get(id);
    }
}