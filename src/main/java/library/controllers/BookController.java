package library.controllers;

import library.model.Book;
import library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@RestController
public class BookController {
    static List<Book> books = new ArrayList<>();
    public BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public List<Book> getAll() throws SQLException, ClassNotFoundException {

/*      List<Book> books = new ArrayList<>();
        Book book = new Book("BOOK_NAME", "BOOK_AUTHOR", "BOOK_DESCRIPTION");
        Book book1 = new Book("BOOK_NAME1", "BOOK_AUTHOR1", "BOOK_DESCRIPTION1");
        bookService.add(book);
        bookService.add(new Book("BOOK_NAME1", "BOOK_AUTHOR1", "BOOK_DESCRIPTION1"));
        bookService.allBooks();

        books.add(book);
        books.add(book1);
        return bookService.allBooks();
        return books;*/

        //List<Book> books = new ArrayList<>();

        try {

            Class.forName("org.h2.Driver"); //Проверяем наличие JDBC драйвера для работы с БД
            Connection connection = DriverManager.getConnection("jdbc:h2:Documents/h2/database./test", "adam", "!Admin26");//соединениесБД
            System.out.println("Соединение с СУБД выполнено.");

            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT * FROM BOOKS");

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String author = resultSet.getString("author");
                String description = resultSet.getString("description");
                BookService bookService = new BookService();
                bookService.add(new Book(name, author, description));
                System.out.println(bookService.allBooks());
            }

            connection.close();       // отключение от БД
            System.out.println("Отключение от СУБД выполнено.");

        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // обработка ошибки  Class.forName
            System.out.println("JDBC драйвер для СУБД не найден!");
        } catch (SQLException e) {
            e.printStackTrace(); // обработка ошибок  DriverManager.getConnection
            System.out.println("Ошибка SQL !");
        }
        return bookService.allBooks();

    }
}
