package library.dao;

import library.model.Book;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class BookDAO {
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private static Map<Integer, Book> books = new HashMap<>();

    public List<Book> allBooks() {
        return new ArrayList<>(books.values());
    }

    public void add(Book book) {
        book.setId(AUTO_ID.getAndIncrement());
        books.put(book.getId(),book);
    }

    public void delete(Book book) {
        books.remove(book.getId());
    }

    public void edit(Book book) {
        books.put(book.getId(),book);
    }

    public Book getById(int id) {
        return books.get(id);
    }
}